// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//路由
import Index from './components/Index.vue'
import GoodsInfo from './components/GoodsInfo.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import MyCenter from './components/MyCenter.vue'
import ManagerPage from './components/ManagerPage.vue'
import ShoppingCar from './components/ShoppingCar.vue'
import search from './components/search.vue'

//个人中心二级路由
import Info from './components/MyCenterComponents/Info.vue'
import Orders from './components/MyCenterComponents/Orders.vue'
import ReadToConsignment from './components/MyCenterComponents/ReadToConsignment.vue'
import ReadToEvaluate from './components/MyCenterComponents/ReadToEvaluate.vue'
import ReadToReceived from './components/MyCenterComponents/ReadToReceived.vue'

//超市管理二级路由
import ManagerGoods from './components/ManagerComponents/ManagerGoods.vue'
import ManagerUser from './components/ManagerComponents/ManagerUser.vue'
import SupermarketData from './components/ManagerComponents/SupermarketData.vue'
import Goods from './components/ManagerComponents/Goods.vue'

//超市管理三级路由
import GoodsEdit from './components/ManagerComponents/GoodsManage/editGoods.vue'
import updateGoods from './components/ManagerComponents/GoodsManage/updateGoods.vue'
import EvaluationScoring from './components/ManagerComponents/GoodsManage/EvaluationScoring.vue'

Vue.use(VueRouter)
Vue.use(ElementUI);

Vue.prototype.$http = axios;

Vue.config.productionTip = false


const routes = [{
    path: '/Manager/GoodsEdit',
    name: 'GoodsEdit',
    component: GoodsEdit
  },
  {
    path: '/Manager/updateGoods',
    name: 'updateGoods',
    component: updateGoods
  },
  {
    path: '/Manager/EvaluationScoring',
    name: 'EvaluationScoring',
    component: EvaluationScoring
  },
  {
    path: '/ShoppingCarPage',
    name: 'shoppingCarPage',
    component: ShoppingCar
  },
  {
    path: '/searchPage',
    name: 'searchPage',
    component: search
  },
  {
    path: '/indexPage',
    name: 'indexPage',
    component: Index
  },
  {
    path: '/goodsInfoPage',
    name: 'goodsInfoPage',
    component: GoodsInfo
  },
  {
    path: '/loginPage',
    name: 'loginPage',
    component: Login
  },
  {
    path: '/registerPage',
    name: 'registerPage',
    component: Register
  },
  {
    path: '/myCenterPage',
    name: 'myCenterPage',
    component: MyCenter,
    children: [{
        path: '/MyCenter/Info',
        name: 'infoPage',
        component: Info
      },
      {
        path: '/MyCenter/Orders',
        name: 'ordersPage',
        component: Orders
      },
      {
        path: '/MyCenter/ReadToConsignment',
        name: 'readToConsignmentPage',
        component: ReadToConsignment
      },
      {
        path: '/MyCenter/ReadToEvaluate',
        name: 'readToEvaluatePage',
        component: ReadToEvaluate
      },
      {
        path: '/MyCenter/ReadToReceived',
        name: 'readToReceivedPage',
        component: ReadToReceived
      },
    ]
  },
  {
    path: '/ManagerPage',
    name: 'ManagerPage',
    component: ManagerPage,
    children: [{
        path: '/Manager/ManagerGoods',
        name: 'ManagerGoods',
        component: ManagerGoods,
      },
      {
        path: '/MyCenter/ManagerUser',
        name: 'ManagerUser',
        component: ManagerUser
      },
      {
        path: '/Manager/Goods',
        name: 'Goods',
        component: Goods
      },
      {
        path: '/MyCenter/SupermarketData',
        name: 'SupermarketData',
        component: SupermarketData
      }
    ]
  },
  {
    path: '*',
    redirect: 'indexPage'
  },
]
const router = new VueRouter({
  routes,
  mode: 'history'
})

var state = {
  isLogin: 0, //初始时候给一个 isLogin=0 表示用户未登录
};
const mutations = {
  changeLogin(state, data) {
    state.isLogin = data;
  }
};


// //全局守卫
// router.beforeEach((to,from,next) => {
//   if(to.path == '/indexPage' || to.path == '/loginPage' || to.path == '/registerPage'){
//     alert("该页面为放行页面");
//   }else{
//     alert("禁止未登录时进入该页面");
//     this.$http
//           .post("/api/test/checkLogin", )
//           .then(function(response) {
//             if (response.data.success) {
//               alert("已登录");
//             } else {
//               alert("未登录");
//               this.$router.replace({ name: "indexPage" });
//             }
//           })
//           .catch(function(error) {
//             this.$router.replace({ name: "indexPage" });
//           });
//   }
//   next();
// })


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
