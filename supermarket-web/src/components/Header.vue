<template>
  <div class="hello">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      background-color="#969696"
      text-color="#fff"
      active-text-color="#ffd04b"
      v-if="isShow"
    >
      <el-menu-item index="1">
        <router-link :to="{name:'indexPage'}">在线超市管理系统</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <router-link :to="{name:'registerPage'}">注册</router-link>
      </el-menu-item>
      <el-menu-item index="4">
        <router-link :to="{name:'loginPage'}">登录</router-link>
      </el-menu-item>
      <el-menu-item index="5">
        <el-badge :value="16" :max="100" class="item">
          <router-link :to="{name:'shoppingCarPage'}">购物车</router-link>
        </el-badge>
      </el-menu-item>
      <el-menu-item style="float:left" index="6">
        <el-input v-model="searchContext"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="searchGoods()">搜索</el-button>
      </el-menu-item>
      <el-menu-item style="float:right" index="6">
        <router-link :to="{name:'indexPage'}">退出</router-link>
      </el-menu-item>
      <el-menu-item style="float:right" index="7">
        <router-link :to="{name:'myCenterPage'}">个人中心</router-link>
      </el-menu-item>
      <el-menu-item style="float:right" index="8">
        <router-link :to="{name:'myCenterPage'}">你好！小明</router-link>
      </el-menu-item>
      <el-menu-item style="float:right" index="9" v-if="isAuthor">
        <router-link :to="{name:'ManagerPage'}">商品管理</router-link>
      </el-menu-item>
    </el-menu>
    <!-- elementui -->
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      msg: "",
      activeIndex: "1",
      isShow: true,
      isAuthor: false,
      searchContext: ""
    };
  },
  methods: {
    searchGoods() {
      var searchContext = this.searchContext;
      this.$router.push({
        name: "searchPage",
        query: { searchContext: searchContext }
      });
    }
  },
  created: function() {
    if (
      this.$route.name == "GoodsEdit" ||
      this.$route.name == "updateGoods" ||
      this.$route.name == "EvaluationScoring"
    ) {
      this.isShow = false;
    } else {
      this.isShow = true;
    }

    this.$http({
      method: "post",
      url: "/api/user/isAuthor",
      params: {}
    }).then(res => {
      if (res.data != null) {
        if (res.data.data == "1") {
          this.isAuthor = true;
        }
      }
    });
  }
};
</script>

<style scoped>
a {
  text-decoration: none;
}
.router-link-active {
  text-decoration: none;
}
.item {
  margin-top: 0px;
  margin-right: 20px;
}
</style>
