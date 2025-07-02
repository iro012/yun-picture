import { getLoginUser } from '@/api/userController'
import { defineStore } from 'pinia'
import { ref } from 'vue'


// 创建登录用户状态管理store
export const useLoginUserStore = defineStore('loginUser', () => {
  // 用户信息状态
  const loginUser = ref<API.UserVO>({
    userName: "未登录"
  })

  // 获取登录用户信息
  async function fetchLoginUser() {
    const res = await getLoginUser()
    if (res.data.code === 200 && res.data.data) {
      loginUser.value = res.data.data
    }
  }

  function setLoginUser(user: API.UserVO) {
    loginUser.value = user
  }

  return {
    loginUser,
    fetchLoginUser,
    setLoginUser,
  }
})
