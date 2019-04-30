<template>
  <div>
    <h1>{{ msg }}</h1>
    <template>
      <div id="box">
        <el-table
          ref="singleTable"
          :data="tableData"
          highlight-current-row
          style="float:left;width:100%"
        >
          <el-table-column type="index" width="60"></el-table-column>
          <el-table-column prop="resource_img" label="图片" width="200">
            <template slot-scope="scope">
              <img :src="'/static/images'+scope.row.resource_img" min-width="70" height="70">
            </template>
          </el-table-column>
          <el-table-column property="resource_name" label="名称" width="220"></el-table-column>
          <el-table-column property="resource_price" label="价格" width="120"></el-table-column>
          <el-table-column property="resource_dec" label="描述" width="220"></el-table-column>
          <el-table-column label="操作" width="120">
            <template slot-scope="scope">
              <el-button type="success" size="mini" @click="handleEdit(scope.row.resource_id)">评价商品</el-button>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="120">
            <template slot-scope="scope">
              <el-button
                type="danger"
                icon="el-icon-delete"
                circle
                @click="handleDelete(scope.row.resource_id)"
              ></el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div style="float:left">
        <div id="pageHelpe">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="goodsTotal"
            @current-change="currentPage"
          ></el-pagination>
        </div>
      </div>
    </template>
  </div>
</template>

<script>
import qs from "qs";
export default {
  name: "GoodsInfo",
  data() {
    return {
      msg: "Welcome to 待评价页面",
      tableData: [],
      getGoodsParam: {
        order_status: "3",
        pageNum: 1,
        pageSize: 8
      },
      goodsTotal: 0
    };
  },
  methods: {
    goToIndex() {},
    getResourceList() {
      this.$http
        .post(
          "/api/orders/getOrderListByUserAndStatus",
          qs.stringify(this.getGoodsParam)
        )
        .then(res => {
          this.tableData = res.data.data;
          this.goodsTotal = res.data.page.dataCount;
        });
    },
    currentPage(currentPage) {
      this.getGoodsParam.pageNum = currentPage;
      this.getResourceList();
    },
    handleEdit(resource_id) {
      layer.open({
        type: 2,
        title: "添加商品",
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ["400px", "220px"],
        content:
          "http://localhost:8081/Manager/EvaluationScoring?resourceId=" +
          resource_id,
        end: function() {
          location.reload();
        }
      });
    }
  },
  created: function() {
    this.getResourceList();
  }
};
</script>

<style scoped>
#box img {
  display: inline-block;
  width: 40px;
  height: 35px;
}
#box li {
  padding: 3px;
  list-style: none;
  margin-right: 15px;
  border: 1px solid #eee;
}
#box span {
  padding-left: 20px;
  font-size: 1rem;
}
</style>