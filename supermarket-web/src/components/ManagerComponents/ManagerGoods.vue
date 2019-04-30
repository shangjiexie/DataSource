<template>
  <div>
    <h1>{{ msg }}</h1>
    <i style="float:right;width=300px" class="el-icon-edit" @click="fn">添加商品</i>
    <div id="box">
      <el-table ref="singleTable" :data="tableData" highlight-current-row style="width: 100%">
        <el-table-column type="index" width="60"></el-table-column>
        <el-table-column prop="resource_img" label="图片" width="100">
          <template slot-scope="scope">
            <img :src="'/static/images'+scope.row.resource_img" min-width="70" height="70">
          </template>
        </el-table-column>
        <el-table-column property="resource_name" label="名称" width="120"></el-table-column>
        <el-table-column property="resource_price" label="价格" width="120"></el-table-column>
        <el-table-column property="resource_dec" label="描述"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="fnUpdateGoods(scope.row.resource_id)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row.resource_id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
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

<script>
import qs from "qs";
export default {
  name: "Register",
  data() {
    return {
      pageHelp: {
        limit: 8,
        current: 1
      },
      getGoodsParam: {
        resource_type: this.resource_sort,
        pageNum: 1,
        pageSize: 8
      },
      goodsTotal: 0,
      msg: "Welcome to 商品管理界面",
      tableData: []
    };
  },
  props: {
    resource_sort: ""
  },
  methods: {
    getResourceList() {
      this.$http
        .post(
          "/api/resource/getAllResourceList",
          qs.stringify(this.getGoodsParam)
        )
        .then(res => {
          this.tableData = res.data.data;
          this.goodsTotal = res.data.page.dataCount;
        });
    },
    handleEdit(res_id) {
      console.log(res_id);
    },
    handleDelete(res_id) {
      this.$http({
        method: "post",
        url: "/api/resource/deleteResource",
        params: {
          resId: res_id
        }
      }).then(res => {});
    },
    currentPage(currentPage) {
      this.getGoodsParam.pageNum = currentPage;
      this.getResourceList();
    },
    fn() {
      layer.open({
        type: 2,
        title: "添加商品",
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ["800px", "500px"],
        content: "http://localhost:8081/Manager/GoodsEdit",
        end: function() {
          location.reload();
        }
      });
    },
    fnUpdateGoods(resourceId) {
      layer.open({
        type: 2,
        title: "添加商品",
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ["800px", "500px"],
        content:
          "http://localhost:8081/Manager/updateGoods?resourceId=" + resourceId,
        end: function() {
          location.reload();
        }
      });
    }
  },
  created: function() {
    this.getResourceList();
  },
  watch: {}
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