<template>
  <div
    style="background:url('static/img/login.png')no-repeat;height:666px;width:100%;margin-top:-100px;overflow: hidden;background-size:100%;"
  >
    <div
      style="background:#FFFFFF;margin-top:10%;margin-left:40%;border:0px solid #000;width:22%;height:35%;"
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
          <td>密码</td>
          <td>
            <el-input label="密码" v-model="user.user_password"></el-input>
          </td>
        </tr>
        <tr>
          <td>验证码</td>
          <td>
            <el-input label="验证码" style="width:110px" v-model="user.code"></el-input>
            <div style="float:right;margin-top:5px" @click="createCode">
              <input type="text" v-model="verificationCode" style="width:80px;height:30px" disabled>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <el-button @click="goToRegister">注册</el-button>
          </td>
          <td>
            <el-button type="primary" @click="submitForm" style="float:right">登陆</el-button>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "Login",
  data() {
    return {
      msg: "登录",
      user: {
        user_name: "",
        user_password: "",
        code: ""
      },
      verificationCode: ""
    };
  },

  methods: {
    goToRegister() {
      this.$router.replace({ name: "registerPage" });
    },
    submitForm() {
      if (this.user.user_name == null || this.useruser_name == "") {
        layer.msg("请输入用户名！");
        return;
      } else if (
        this.user.user_password == null ||
        this.user.user_password == ""
      ) {
        layer.msg("请输入密码！");
      } else if (this.user.code == "" || this.user.code == null) {
        layer.msg("请输入验证码！");
        return;
      }
      if (this.user.code != this.verificationCode) {
        layer.msg("验证码不正确！");
        return;
      }
      var params = this.user;
      this.$http
        .post("/api/user/login", qs.stringify(params))
        .then(function(response) {
          if (response.data.success) {
            alert("登录成功");
          } else {
            alert("账号或密码错误");
          }
        })
        .catch(function(error) {
          alert("登录超时");
        });
    },
    createdCode() {
      //先清空验证码的输入
      this.code = "";
      this.checkCode = "";
      this.picLyanzhengma = "";
      //验证码的长度
      var codeLength = 4;
      //随机数
      var random = new Array(
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z"
      );
      for (var i = 0; i < codeLength; i++) {
        //取得随机数的索引（0~35）
        var index = Math.floor(Math.random() * 36);
        //根据索引取得随机数加到code上
        this.code += random[index];
      }
      //把code值赋给验证码
      this.verificationCode = this.code;
    },
    createCode() {
      this.createdCode();
    }
  },
  created: function() {
    this.createdCode();
  }
};
</script>

<style scoped>
</style>