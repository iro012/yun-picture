<script setup lang="ts">
import { ref, reactive } from 'vue'
import { Form, Input, Button, Card, message } from 'ant-design-vue'
import type { FormInstance } from 'ant-design-vue'
import { useRouter } from 'vue-router'
import { register, userRegister } from '@/api/userController'

const router = useRouter()
const loading = ref(false)
const registerForm = ref<FormInstance | null>(null)

// 表单验证规则
const rules = {
  userAccount: [
    { required: true, message: '请输入账号', trigger: ['blur', 'change'] },
    { min: 3, max: 20, message: '账号长度在 3 到 20 个字符', trigger: ['blur', 'change'] },
  ],
  userPassword: [
    { required: true, message: '请输入密码', trigger: ['blur', 'change'] },
    { min: 8, message: '密码长度不能少于 8 个字符', trigger: ['blur', 'change'] },
  ],
  checkPassword: [
    { required: true, message: '请确认密码', trigger: ['blur', 'change'] },
    {
      validator: (_, value) => {
        if (!value || formState.userPassword === value) {
          return Promise.resolve()
        }
        return Promise.reject(new Error('两次输入的密码不一致'))
      },
      trigger: ['blur', 'change'],
    },
  ],
}

// 表单数据
const formState = reactive({
  userAccount: '',
  userPassword: '',
  checkPassword: '',
})

// 提交注册表单
const handleSubmit = async () => {
  if (!registerForm.value) return
  loading.value = true
  // 先进行表单验证
  await registerForm.value.validate()
  // 验证通过后提交数据
  const res = await userRegister({
    userAccount: formState.userAccount,
    userPassword: formState.userPassword,
    checkPassword: formState.checkPassword,
  })
  console.log(res)

  if (res.data.code === 0) {
    message.success('注册成功，请登录')
    router.push({
      path: '/user/login',
      replace: true,
    })
  } else {
    message.error(res.data.message || '注册失败')
  }
  loading.value = false
}
</script>

<template>
  <div class="register-container">
    <Card class="register-card" title="用户注册">
      <a-form
        ref="registerForm"
        v-model:model="formState"
        :rules="rules"
        layout="vertical"
        class="register-form"
      >
        <a-form-item name="userAccount" label="账号">
          <Input v-model:value="formState.userAccount" placeholder="请输入账号" />
        </a-form-item>
        <a-form-item name="userPassword" label="密码">
          <Input.Password v-model:value="formState.userPassword" placeholder="请输入密码" />
        </a-form-item>
        <a-form-item name="checkPassword" label="确认密码">
          <Input.Password v-model:value="formState.checkPassword" placeholder="请确认密码" />
        </a-form-item>
        <a-form-item>
          <Button type="primary" class="register-button" :loading="loading" @click="handleSubmit">
            注册
          </Button>
        </a-form-item>
        <div class="login-link">
          已有账号？ <a @click="() => router.push('/login')">立即登录</a>
        </div>
      </a-form>
    </Card>
  </div>
</template>

<style scoped>
.register-container {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f5f5f5;
}

.register-card {
  width: 400px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.register-form {
  margin-top: 20px;
}

.register-button {
  width: 100%;
  height: 40px;
  font-size: 16px;
}

.login-link {
  text-align: center;
  margin-top: 16px;
  color: #666;
}

.login-link a {
  color: #1890ff;
  text-decoration: none;
}
</style>
