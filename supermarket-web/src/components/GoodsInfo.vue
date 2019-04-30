<template>
  <div>
    <el-container>
      <el-main style="width:100%;height:650px;float:left">
        <el-aside style="background:#FFFAF0;width:70%;height:610px;float:left;margin-top:0px">
          <div style="width:300px;height:300px;float:left">
            <img width="500px" height="350px" :src="'/static/images'+goodInfo.resource_img">
            <br>
            <br>
            <div style="margin-top:20px" v-show="isShow">
              <img style="float:left" width="550px" height="200px" src="/static/img/xfzbz3.png">
            </div>
            <div style="margin-top:20px;margin-left:20px;width:666px;" v-show="commentsShow">
              <h1>{{isHasComment}}</h1>
              <ul>
                <li v-for="v in commonData" :key="v.index">
                  <i class="el-icon-time"></i>
                  <span>：{{v.comment_time}}</span>
                  <span>用户：{{v.comment_user_name}}评论：</span>
                  <span class="fontSize">{{v.comment_content}}</span>
                </li>
              </ul>
              <br>
              <br>
              <br>
              <el-pagination
                background
                layout="prev, pager, next"
                :total="commentsCount"
                page-size="5"
                @current-change="currentPage"
              ></el-pagination>
            </div>
          </div>
          <div style="width:400px;height:500px;float:right;" align="left">
            <br>
            <br>
            <span>总评分：</span>
            <el-rate v-model="score" disabled show-score text-color="#ff9900" style="float:right"></el-rate>
            <br>
            <br>
            <br>
            <span class="fontSize" style="font-size:26px;">价格：</span>
            <span class="fontSize" style="font-size:26px;color:red">{{goodInfo.resource_price}}元</span>
            <br>
            <span class="fontSize">名称：</span>
            <span class="fontSize">{{goodInfo.resource_name}}</span>

            <br>
            <span class="fontSize">规格：</span>
            <span class="fontSize">{{goodInfo.resource_specification}}</span>
            <br>
            <span class="fontSize">描述：</span>
            <span class="fontSize">{{goodInfo.resource_dec}}</span>
            <br>
            <span class="fontSize">销量：</span>
            <span class="fontSize">{{goodInfo.resource_sales_volume}}</span>
            <br>
            <span class="fontSize">库存：</span>
            <span class="fontSize">{{goodInfo.resource_inventory}}</span>
            <br>
            <span class="fontSize">累计评价：</span>
            <span class="fontSize">{{goodInfo.resource_evaluate_count}}</span>
            <br>
            <div style="float:right">
              <span>浏览量：</span>
              <span>{{goodInfo.resource_view_count}}</span>
            </div>

            <br>
            <el-input-number
              v-model="goodCount"
              @change="handleChange"
              :min="1"
              :max="10"
              label="描述文字"
            ></el-input-number>
            <br>
            <br>
            <el-button type="success" @click="buyGood">立即购买</el-button>
            <el-button type="success" @click="toMyCart">加入购物车</el-button>
            <el-button type="success" @click="showComment">查看评价</el-button>
            <br>
          </div>
        </el-aside>
        <el-aside style="background:#FFFAF0;width:26%;height:610px;float:right;margin-top:0px">
          <h2>相关商品推荐</h2>
          <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="resource_img" label="图片" width="130">
              <template slot-scope="scope">
                <img
                  width="100px"
                  height="75px"
                  :src="'/static/images'+scope.row.resource_img"
                  @click="goToGoodInfo(scope.row.resource_id)"
                >
              </template>
            </el-table-column>
            <el-table-column prop="resource_name" label="名称" width="130"></el-table-column>
            <el-table-column prop="resource_price" label="价格"></el-table-column>
          </el-table>
        </el-aside>
      </el-main>

      <el-footer
        style="background:#FFE4B5;width:100%;height:200px;overflow: hidden;margin-left:-60px"
      >
        <img
          style="margin-left:-20px"
          width="110%"
          height="200px"
          src="../../static/img/xfzbz1.png"
        >
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "GoodsInfo",
  data() {
    return {
      msg: "Welcome to 商品详情页",
      isHasComment: "",
      score: 5,
      goodCount: 1,
      active: 0,
      isShow: true,
      commentsShow: false,
      commentsCount: 10,
      getGoodsParam: {
        resource_type: "",
        pageNum: 1,
        pageSize: 5
      },
      commentParam: {
        pageNum: 1,
        pageSize: 5
      },
      tableData: [],
      goodInfo: {},
      commonData: []
    };
  },
  methods: {
    goToIndex() {
      this.$router.go(-1);
    },
    handleChange() {},
    alertGoodId() {
      var goodId = this.$route.query.goodId;
      this.getGoodInfo(goodId);
      this.getComments(goodId);
      this.getScore(goodId);
    },
    getGoodInfo(goodId) {
      this.$http({
        method: "post",
        url: "/api/resource/getResourceByResourceId",
        params: {
          resource_id: goodId
        }
      }).then(res => {
        this.goodInfo = res.data.data;
        this.getGoodsParam.resource_type = res.data.data.resource_type;
        this.getResourceList();
        this.getComments(goodId);
        this.getScore(goodId);
        this.getCommentCountByResourceId(goodId);
      });
    },
    getComments(goodId) {
      this.$http({
        method: "post",
        url: "/api/commentDate/getCommentListByResourceId",
        params: {
          resource_id: goodId,
          pageNum: this.commentParam.pageNum,
          pageSize: this.commentParam.pageSize
        }
      }).then(res => {
        if (res.data.data.length == 0) {
          this.isHasComment = "暂无评论数据";
        } else {
          this.isHasComment = "";
        }
        this.commonData = res.data.data;
      });
    },
    getCommentCountByResourceId(goodId) {
      this.$http({
        method: "post",
        url: "/api/commentDate/getCommentCountByResourceId",
        params: {
          resource_id: goodId
        }
      }).then(res => {
        this.commentsCount = res.data.data;
      });
    },
    getScore(goodId) {
      this.$http({
        method: "post",
        url: "/api/commentDate/avgScore",
        params: {
          resource_id: goodId
        }
      }).then(res => {
        if (res.data.data != null) {
          this.score = parseFloat(res.data.data);
        }
      });
    },
    getResourceList() {
      this.$http
        .post("/api/resource/getResourceList", qs.stringify(this.getGoodsParam))
        .then(res => {
          this.tableData = res.data.data;
          this.goodsTotal = res.data.page.dataCount;
        });
    },
    goToGoodInfo(goodId) {
      this.$router.push({ name: "goodsInfoPage", query: { goodId: goodId } });
      this.getGoodInfo(goodId);
    },
    showComment() {
      this.isShow = false;
      this.commentsShow = true;
    },
    currentPage(currentPage) {
      this.commentParam.pageNum = currentPage;
      var goodId = this.$route.query.goodId;
      this.getComments(goodId);
    },
    toMyCart() {
      var resourceId = this.goodInfo.resource_id;
      this.$http({
        method: "post",
        url: "/api/resource/addCart",
        params: {
          resourceId: resourceId
        }
      }).then(res => {
        if (res.data.data != null) {
          this.score = parseFloat(res.data.data);
        }
      });
      layer.msg("加入购物车成功！");
    },
    buyGood() {
      var ajax = this.$http;
      var resourceId = this.goodInfo.resource_id;
      layer.confirm("确认购买该商品嘛?", function(index) {
        var tip = "购买该商品将发货到您个人中心的默认地址！确认购买？";
        layer.confirm(tip, function(index) {
          ajax({
            method: "post",
            url: "/api/orders/addOrder",
            params: {
              resourceId: resourceId
            }
          }).then(res => {
            if (res.data.data != null) {
              this.score = parseFloat(res.data.data);
            }
          });
          layer.msg("购买成功！");
          layer.close(index);
        });
        layer.close(index);
      });
    }
  },
  created() {
    this.alertGoodId();
  }
};
</script>

<style scoped>
.fontSize {
  font-size: 20px;
}
</style>