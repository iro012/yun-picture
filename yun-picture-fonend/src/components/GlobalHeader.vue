<script lang="ts" setup>
import { h, ref } from 'vue'
import { MailOutlined } from '@ant-design/icons-vue'
import { MenuProps } from 'ant-design-vue'

const current = ref<string[]>(['mail'])
import { useRouter } from 'vue-router'

const router = useRouter()

const handleMenuClick = ({ key }: { key: string }) => {
  router.push(key)
}

const items = ref<MenuProps['items']>([
  {
    key: '/home',
    label: '主页',
    title: '主页',
  },
])
</script>

<template>
  <div id="global-header">
    <a-row>
      <a-col flex="200px">
        <div class="title-bar">
          <img class="image" src="../assets/img/logo.jpg" alt="" width="64px" height="64px" />
          <h1 class="title">浩图云境</h1>
        </div>
      </a-col>
      <a-col flex="auto">
        <a-menu
          v-model:selectedKeys="current"
          mode="horizontal"
          :items="items"
          @select="handleMenuClick"
        />
      </a-col>
      <a-col flex="200px">
        <div class="login-button">
          <a-button @click="() => router.replace('/user/login')" type="primary">登录</a-button>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<style scoped>
#global-header {
  .title-bar {
    display: flex;
    align-items: center;

    .title {
      font-size: 16px;
      color: #000;
      margin-left: 16px;
    }
  }
}
</style>
