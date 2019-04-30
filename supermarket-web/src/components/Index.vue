<template>
  <div>
    <el-container>
      <el-container>
        <el-aside width="200px">
          <div>
            <div class="block">
              <el-row class="block-col-2">
                <el-col :span="20">
                  <el-button plain>休闲</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="primary" plain>饮品</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="success" plain>奶制</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="info" plain>膨化</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="warning" plain>饼干</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="danger" plain>糖果</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="primary" plain>面包</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="success" plain>促销</el-button>
                </el-col>
                <el-col :span="20">
                  <el-button type="warning" plain>秒杀</el-button>
                </el-col>
              </el-row>
            </div>
          </div>
        </el-aside>
        <el-main>
          <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="item in bannerImgLst" :key="item">
              <img :src="'../../static/img/'+ item" width="100%">
            </el-carousel-item>
          </el-carousel>
        </el-main>
        <el-aside width="200px">
          <div>
            <h2>欢迎您</h2>
            <h2>小明</h2>
          </div>
        </el-aside>
      </el-container>
      <el-main>
        <div>
          <show-goods v-bind:resource_sort="10003"></show-goods>
        </div>
      </el-main>
      <el-footer>
        <div>
          <em>版权所有 联系方式：15755337603 联系人:sjxie</em>
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import show from "../components/Show";
import qs from "qs";
export default {
  name: "Index",
  components: {
    showGoods: show
  },
  data() {
    return {
      msg: "Welcome to 首页",
      categories: [
        { className: "水果", classId: "水果" },
        { className: "水果", classId: "水果" },
        { className: "水果", classId: "水果" },
        { className: "水果", classId: "水果" }
      ],
      bannerImgLst: ["lb1.png", "lb2.png", "lb3.png", "lb4.png"],
      resource_sort: "1"
    };
  },
  methods: {
    handleChange(value) {
      console.log(value);
    }
  }
};
</script>

<style scope>
.el-header,
.el-footer {
  background-color: #5e6368;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 20px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.list li {
  list-style-type: none;
}
</style>