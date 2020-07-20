<template>
  <div id="app">
    <p>
      <router-link to="/post">Go to Post</router-link>
      <router-link to="/load">Go to Load</router-link>
    </p>
    <router-view></router-view>
  </div>
</template>

<script>
  // import PostMessage from "./components/PostMessage";

  export default {
    name: 'App',
    components: {
      // PostMessage,
    }
  }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
