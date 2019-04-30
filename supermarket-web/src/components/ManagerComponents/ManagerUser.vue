<template>
  <div>
    <h1>{{ msg }}</h1>
    <el-table :data="userList" style="width: 100%">
      <el-table-column prop="user_name" label="用户名" width="180"></el-table-column>
      <el-table-column prop="user_email" label="邮箱" width="180"></el-table-column>
      <el-table-column prop="user_adress" label="地址"></el-table-column>
      <el-table-column prop="user_adress" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="freeze(scope.row.user_id , 2)">冻结账号</el-button>
          <el-button size="mini" @click="freeze(scope.row.user_id , 3)">重置密码</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "Register",
  data() {
    return {
      getGoodsParam: {
        resource_type: 3,
        pageNum: 1,
        pageSize: 6
      },
      msg: "Welcome to 用户管理界面",
      userList: []
    };
  },
  props: {
    resource_sort: ""
  },
  methods: {
    getUserList() {
      this.$http({
        method: "post",
        url: "/api/user/getUerList",
        params: {
          pageNum: 1,
          pageSize: 8
        }
      }).then(res => {
        this.userList = res.data.data;
      });
    },
    freeze(userId, userType) {
      this.$http({
        method: "post",
        url: "/api/user/updateUserType",
        params: {
          userId: userId,
          userType: userType
        }
      }).then(res => {
        this.userList = res.data.data;
      });
    }
  },
  created: function() {
    this.getUserList();
  }
};
</script>

<style scoped>
</style>