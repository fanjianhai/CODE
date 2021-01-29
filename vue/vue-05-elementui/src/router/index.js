import Vue from 'vue'
import VueRouter from "vue-router"

import Main from "../views/Main"
import Login from "../views/Login"
import UserProfile from "../views/user/Profile";
import UserList from "../views/user/List";

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/main',
      component: Main,
      children: [
        {path: '/user/profile/:id', name: 'UserProfile', component: UserProfile, props: true},
        {path: '/user/list', component: UserList}
      ]
    },
    {
      path: '/login',
      component: Login

    }
  ]
});
