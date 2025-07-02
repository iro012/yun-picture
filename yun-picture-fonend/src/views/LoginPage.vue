<template>
  <div class="login-container">
    <Card class="login-card" title="用户登录">
      <a-form
        ref="loginForm"
        :model="formState"
        :rules="rules"
        layout="vertical"
        class="login-form"
        @finish="handleSubmit"
      >
        <a-form-item name="userAccount" label="账号">
          <Input v-model:value="formState.userAccount" placeholder="请输入账号" />
        </a-form-item>
        <a-form-item name="userPassword" label="密码">
          <Input.Password v-model:value="formState.userPassword" placeholder="请输入密码" />
        </a-form-item>
        <a-form-item>
          <Button type="primary" class="login-button" :loading="loading" html-type="submit">
            登录
          </Button>
        </a-form-item>
        <div class="register-link">
          还没有账号？ <a @click="() => router.push('/user/register')">立即注册</a>
        </div>
      </a-form>
    </Card>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { Form, Input, Button, Card, message, FormInstance } from 'ant-design-vue'
import { useRouter } from 'vue-router'
import { login, userLogin } from '@/api/userController'
import { useLoginUserStore } from '@/stores/useLoginUserStore'

const router = useRouter()
const loginStore = useLoginUserStore()
const loading = ref(false)
const loginForm = ref<API.UserLoginRequest>({})

// 响应式表单数据
const formState = reactive({
  userAccount: '',
  userPassword: '',
})

// 表单验证规则
const rules = {
  userAccount: [
    { required: true, message: '请输入账号', trigger: 'blur' },
    { min: 3, max: 20, message: '账号长度在 3 到 20 个字符之间', trigger: 'blur' },
  ],
  userPassword: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 8, message: '密码长度不能少于 8 个字符', trigger: 'blur' },
  ],
}

// 提交处理函数
const handleSubmit = async () => {
  if (!loginForm.value) return
  loading.value = true
  // 提交登录请求
  const res = await userLogin({
    userAccount: formState.userAccount,
    userPassword: formState.userPassword,
  })
  if (res.data.code === 0) {
    loginStore.setLoginUser(res.data.data || {})
    message.success('登录成功')
    router.push({
      path: '/',
      replace: true,
    })
  } else {
    message.error(res.data.message || '登录失败')
  }
  loading.value = false
}
</script>

<style scoped>
.login-container {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f5f5f5;
}

.login-card {
  width: 400px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.login-form {
  margin-top: 20px;
}

.login-button {
  width: 100%;
  height: 40px;
  font-size: 16px;
}

.register-link {
  text-align: center;
  margin-top: 16px;
  color: #666;
}

.register-link a {
  color: #1890ff;
  text-decoration: none;
}
</style>
