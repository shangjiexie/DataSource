<template>
  <div>
    <h1>{{ msg }}</h1>
    <el-form label-position="left" label-width="80px" :model="formLabelAlign" style="float:left">
      <el-form-item label="姓名：">
        <el-input v-model="formLabelAlign.user_name"></el-input>
      </el-form-item>
      <el-form-item label="性别：">
        <el-input v-model="formLabelAlign.user_sex"></el-input>
      </el-form-item>
      <el-form-item label="年龄：">
        <el-input v-model="formLabelAlign.user_age"></el-input>
      </el-form-item>
      <el-form-item label="邮箱：">
        <el-input v-model="formLabelAlign.user_email"></el-input>
      </el-form-item>
      <el-form-item label="手机：">
        <el-input v-model="formLabelAlign.user_phone"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="updateMyInfo">修改</el-button>
      </el-form-item>
    </el-form>
    <div style="float:right;width:300px;margin-left:400px">
      <el-button type="info" style="float:right" plain @click="updatePassWord">修改密码</el-button>
      <img width="300px" height="250px" src="../../../static/images/20190320194230kejian2.png">
    </div>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "GoodsInfo",
  data() {
    return {
      msg: "Welcome to 个人信息页面",
      formLabelAlign: {
        user_id: "未知",
        user_name: "未知",
        user_sex: "未知",
        user_age: "未知",
        user_image: "未知",
        user_email: "未知",
        user_password: "未知",
        user_adress: "未知",
        user_type: "未知",
        user_phone: "未知"
      }
    };
  },
  methods: {
    getMyInfo() {
      this.$http({
        method: "post",
        url: "/api/user/getUserInfo",
        params: {
          user_id: "ccdbab24f1484886a918207776ca59471554167478947"
        }
      }).then(res => {
        this.formLabelAlign = res.data.data;
      });
    },
    updateMyInfo() {
      this.$http
        .post("/api/user/updateMyInfo", qs.stringify(this.formLabelAlign))
        .then(res => {
          if (res.data.data) {
            layer.msg("修改成功");
          }
        });
    },
    layerPrompt(val, index) {
      this.formLabelAlign.user_password = val;
      layer.close(index);
      this.updateMyInfo();
    },
    updatePassWord() {
      layer.prompt(this.layerPrompt);
    }
  },
  created() {
    this.getMyInfo();
  }
};
</script>

<style scoped>
</style>