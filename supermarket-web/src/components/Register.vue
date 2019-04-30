<template>
  <div
    style="background:url('static/img/login.png')no-repeat;height:666px;width:100%;margin-top:-100px;overflow: hidden;background-size:100%;"
  >
    <div
      style="background:#FFFFFF;margin-top:10%;margin-left:40%;border:0px solid #000;width:22%;height:45%;"
    >
      <h1>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{ msg }}</h1>
      <table style="margin-left:15px">
        <tr>
          <td>用户名</td>
          <td>
            <el-input label="用户名" v-model="user.user_name"></el-input>
          </td>
        </tr>
        <tr>
          <td>邮箱</td>
          <td>
            <el-input label="邮箱" v-model="user.user_email"></el-input>
          </td>
        </tr>
        <tr>
          <td>电话</td>
          <td>
            <el-input label="电话" v-model="user.user_phone"></el-input>
          </td>
        </tr>
        <tr>
          <td>密码</td>
          <td>
            <el-input label="密码" v-model="user.user_password"></el-input>
          </td>
        </tr>
        <tr>
          <td>确认密码</td>
          <td>
            <el-input label="确认密码" v-model="user.user_verify_password"></el-input>
          </td>
        </tr>
      </table>
      <el-button style="margin-top:20px;margin-left:40%" @click="submitForm">注册</el-button>
    </div>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "Register",
  data() {
    return {
      msg: "注册",
      user: {
        user_name: "",
        user_email: "",
        user_phone: "",
        user_password: "",
        user_verify_password: ""
      }
    };
  },

  methods: {
    goTologin() {
      this.$router.replace({ name: "loginPage" });
    },
    submitForm() {
      var params = this.user;
      if (params.user_name == "") {
        layer.msg("用户名错误");
        return;
      }
      if (
        !/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)*.[a-zA-Z0-9]{2,6}$/.test(
          params.user_email
        )
      ) {
        layer.msg("邮箱错误");
        return;
      }
      if (!/^1[34578]\d{9}$/.test(params.user_phone)) {
        layer.msg("手机号错误");
        return;
      }
      if (params.user_password != params.user_verify_password) {
        layer.msg("两次输入的密码不一致");
      }
      this.$http
        .post("/api/user/register", qs.stringify(params))
        .then(function(response) {
          if (response.data.success) {
            alert("注册成功");
          } else {
            alert("输入信息有误");
          }
        })
        .catch(function(error) {
          alert("请求超时");
        });
    }
  }
};
</script>

<style scoped>
</style>