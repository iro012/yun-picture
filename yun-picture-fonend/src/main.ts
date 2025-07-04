import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
import App from './App.vue'
import router from './router'
import './assets/main.css'

const app = createApp(App)

// 安装Pinia状态管理
app.use(createPinia())
app.use(Antd)
app.use(router)

app.mount('#app')
