<template>
  <div>
    <h1>评价商品</h1>
    <el-rate v-model="score" show-score text-color="#ff9900" score-template="{value}"></el-rate>
    <hr>
    <el-input v-model="content" placeholder="请输入名称"></el-input>
    <el-button style="display:block;margin:0 auto" type="success" @click="onSubmit()" round>确认添加</el-button>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "GoodsInfo",
  data() {
    return {
      score: 0,
      content: ""
    };
  },
  methods: {
    onSubmit: function() {
      if (this.content == null || this.content == "") {
        layer.msg("请输入评价内容");
        return;
      }
      this.submitFormDate();
      layer.msg("成功");
    },
    submitFormDate: function() {
      var resourceId = this.$route.query.resourceId;
      var score = this.score;
      var content = this.content;
      this.$http({
        method: "post",
        url: "/api/commentDate/addComment",
        params: {
          resourceId: resourceId,
          commentScore: score,
          commentContent: content
        }
      }).then(res => {});
    }
  },
  created() {}
};
</script>

<style scoped>
</style>