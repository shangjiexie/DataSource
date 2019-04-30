<template>
  <div class="hello" style="margin-left:40px">
    <h1>搜索结果</h1>
    <el-tabs>
      <el-tab-pane label="所有商品"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "goodsList",
  data() {
    return {
      resourceList: [],
      type: {
        resource_type: 3,
        pageNum: 1,
        pageSize: 20
      }
    };
  },
  props: {},
  methods: {
    getResourceList() {
      var searchContext = this.$route.query.searchContext;
      this.$http({
        method: "post",
        url: "/api/resource/resourceByResourceLikeName",
        params: {
          searchContext: searchContext
        }
      }).then(res => {
        if (res.data.data != null) {
          this.resourceList = res.data.data;
        }
      });
    },
    goToGoodInfo(goodId) {
      this.$router.push({ name: "goodsInfoPage", query: { goodId: goodId } });
    },
    timeFunction: function() {
      var ajax = this;
      this.invt = setInterval(function() {
        ajax.getResourceList();
      }, 3000);
    }
  },
  created: function() {
    this.timeFunction();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#box ul {
  display: flex;
  flex-wrap: wrap;
}
#box li {
  padding: 3px;
  list-style: none;
  margin-right: 15px;
  border: 1px solid #eee;
  height: 240px;
  width: 180px;
}
#box img {
  display: inline-block;
  width: 190px;
  height: 150px;
}
#box li span {
  height: 20px;
  display: inline-block;
  width: 100%;
  line-height: 20px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.el-tabs__item {
  font-size: 18px;
}
</style>