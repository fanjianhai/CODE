<template>
  <div>
    <h1>个人信息</h1>
    {{$route.params.id}}<br/>
    {{id}}
  </div>
</template>

<script>
export default {
  name: "UserProfile",
  props: ['id'],
  beforeRouteEnter: (to, from, next)=>{
    console.log("进入路由之前...");
    next(vm => {
      vm.getData(); // 进入路由之前执行我们自定义的getData方法
    });
  },
  beforeRouteLeave: (to, from, next)=>{
    console.log("离开路由之前...");
    next();
  },
  methods: {
    getData: function () {
      this.axios({
        method: 'get',
        url: 'http://localhost:8080/static/mock/data.json'
      }).then(function (response) {
        console.log(response)
      });
    }
  }
}
</script>

<style scoped>

</style>
