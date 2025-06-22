<script setup lang="ts">
import GlobalHeader from '@/components/GlobalHeader.vue'
</script>

<template>
  <div id="basic-layout">
    <a-layout>
      <a-layout-header class="header">
        <GlobalHeader />
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer"> 作者：林浩铨，QQ：962230485 </a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#basic-layout {
  min-height: 100vh;
  width: 100vw;

  .header {
    height: 64px;
    line-height: 64px;
    background: #fff;
    /* text-align: center; */
    padding: 0;
  }

  .footer {
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    text-align: center;
  }
}
</style>
