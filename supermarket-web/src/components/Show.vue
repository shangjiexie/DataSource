<template>
  <div class="hello">
    <el-tabs>
      <el-tab-pane label="休闲"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList1" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="饮品"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList2" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="奶制"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList3" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="膨化"></el-tab-pane>
      <div class id="box">
        <ul style="display：table;margin: 0 auto;">
          <li v-for="v in resourceList4" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="饼干"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList5" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="糖果"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList6" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="面包"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList7" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="促销"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList8" :key="v.index">
            <img :src="'/static/images'+v.resource_img" @click="goToGoodInfo(v.resource_id)">
            <span>价格：{{v.resource_price}}</span>
            <span v-bind:title="v.resource_name">名称：{{v.resource_name}}</span>
          </li>
        </ul>
      </div>
    </el-tabs>
    <el-tabs>
      <el-tab-pane label="秒杀"></el-tab-pane>
      <div class id="box">
        <ul>
          <li v-for="v in resourceList9" :key="v.index">
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
      resourceList1: [],
      resourceList2: [],
      resourceList3: [],
      resourceList4: [],
      resourceList5: [],
      resourceList6: [],
      resourceList7: [],
      resourceList8: [],
      resourceList9: [],
      type: {
        resource_type: this.resource_sort,
        pageNum: 1,
        pageSize: 12
      }
    };
  },
  props: {
    resource_sort: ""
  },
  methods: {
    getResourceList1() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10001,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList1 = res.data.data;
      });
    },
    getResourceList2() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10002,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList2 = res.data.data;
      });
    },
    getResourceList3() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10003,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList3 = res.data.data;
      });
    },
    getResourceList4() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10004,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList4 = res.data.data;
      });
    },
    getResourceList5() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10005,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList5 = res.data.data;
      });
    },
    getResourceList6() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10006,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList6 = res.data.data;
      });
    },
    getResourceList7() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10007,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList7 = res.data.data;
      });
    },
    getResourceList8() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10008,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList8 = res.data.data;
      });
    },
    getResourceList9() {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceList",
        params: {
          resource_type: 10009,
          pageNum: 1,
          pageSize: 12
        }
      }).then(res => {
        this.resourceList9 = res.data.data;
      });
    },

    goToGoodInfo(goodId) {
      this.$router.push({ name: "goodsInfoPage", query: { goodId: goodId } });
    }
  },
  created: function() {
    this.getResourceList1();
    this.getResourceList2();
    this.getResourceList3();
    this.getResourceList4();
    this.getResourceList5();
    this.getResourceList6();
    this.getResourceList7();
    this.getResourceList8();
    this.getResourceList9();
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