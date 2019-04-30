<template>
  <div class="cart" style="width:90%">
    <el-table
      :data="myCartTable"
      border
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center"></el-table-column>
      <el-table-column type="index" label="序号" width="100" align="center"></el-table-column>
      <el-table-column prop="resource_img" label="图片" width="150" align="center">
        <template slot-scope="scope">
          <img :src="'/static/images'+scope.row.resource_img" min-width="120" height="90">
        </template>
      </el-table-column>
      <el-table-column prop="resource_name" label="类目" width="100" align="center"></el-table-column>
      <el-table-column prop="resource_dec" label="描述" width="300" align="center"></el-table-column>
      <el-table-column prop="resource_price" label="价格" align="center"></el-table-column>
      <el-table-column label="数量" width="220" align="center">
        <template slot-scope="scope">
          <el-input-number v-model="scope.row.counts" :min="1" :max="10" label="描述文字"></el-input-number>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <!-- <el-button size="mini" @click="editDialog(scope.$index, scope.row)">编辑</el-button> -->
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="total_warpper">
      <h3>共计：{{totalPrice}}</h3>
      <h3>总数：{{totalNumber}}</h3>
    </div>
    <!-- 收货地址确认弹窗的内容 -->
    <el-dialog title="确认收获信息" :visible.sync="addIsDialog" class="addDialog" style="width:100%">
      <el-form :model="myCartData">
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="myCartData.user_name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth">
          <el-input v-model="myCartData.user_phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-select
            style="width:150px"
            v-model="myCartData.user_province"
            autocomplete="off"
            @change="getCity()"
          >
            <el-option
              v-for="item in provinceOptions"
              :key="item.code"
              :label="item.name"
              :value="item.code"
            ></el-option>
          </el-select>
          <el-select
            style="width:150px"
            v-model="myCartData.user_city"
            autocomplete="off"
            @change="getCounty()"
          >
            <el-option
              v-for="item in cityOptions"
              :key="item.code"
              :label="item.name"
              :value="item.code"
            ></el-option>
          </el-select>
          <el-select style="width:150px" v-model="myCartData.user_county" autocomplete="off">
            <el-option
              v-for="item in countyOptions"
              :key="item.code"
              :label="item.name"
              :value="item.code"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="街道" :label-width="formLabelWidth">
          <el-input v-model="myCartData.user_adress" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addIsDialog = false">取 消</el-button>
        <el-button type="primary" @click="addSureBtn">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 添加编辑的内容 -->
    <el-dialog title="添加信息" :visible.sync="editIsDialog" class="addDialog">
      <el-form :model="editData">
        <el-form-item label="类目" :label-width="formLabelWidth">
          <el-input autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth">
          <el-input autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="数量" :label-width="formLabelWidth">
          <el-input autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editIsDialog = false">取 消</el-button>
        <el-button type="primary" @click="editSureBtn">确 定</el-button>
      </div>
    </el-dialog>
    <div class="group_btn">
      <el-button type="success" @click="addDialog">确认购买</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      editIsDialog: false, //编辑弹窗
      addIsDialog: false, //添加弹窗
      multipleSelection: [], //存放已选择的数据
      provinceOptions: [],
      cityOptions: [],
      countyOptions: [],
      myCartData: {
        user_name: "",
        user_phone: "",
        user_province: "省",
        user_city: "市",
        user_county: "县/区",
        user_adress: ""
      },
      editData: {},
      formLabelWidth: "160",
      //表格中的数据
      myCartTable: []
    };
  },
  methods: {
    // 点击发生的变化
    handleSelectionChange(val) {
      this.multipleSelection = val; //给定义的数组赋值
    },
    handleDelete(index, row) {
      this.tableData.splice(index, 1); //删除表格的数据
    },
    // 点击弹出添加弹窗
    addDialog() {
      if (this.totalPrice > 0) {
        this.addIsDialog = true;
      } else {
        layer.msg("请选择商品后结算！");
      }
    },
    // 点击添加弹窗的确定按钮
    addSureBtn() {
      this.addIsDialog = false;
      // this.tableData.push(this.formData);
      // 初始化添加表单
      // alert(this.myCartData.user_name);
      // alert(this.myCartData.user_phone);
      // alert(this.myCartData.user_province);
      // alert(this.myCartData.user_city);
      // alert(this.myCartData.user_county);
      // alert(this.myCartData.user_adress);
      // alert(this.totalPrice);
      // alert(this.allOrders);
      this.checkOutCart(
        this.allOrders,
        this.myCartData.user_name,
        this.myCartData.user_phone,
        this.myCartData.user_province,
        this.myCartData.user_city,
        this.myCartData.user_county,
        this.myCartData.user_adress
      );
      this.myCartData = {
        user_name: "",
        user_phone: "",
        user_province: "",
        user_city: "",
        user_district: "",
        user_adress: ""
      };
    },
    // 点击弹出添加弹窗
    editDialog(index, row) {
      this.editIsDialog = true;
      this.editData = row;
    },
    editSureBtn(row, index) {
      this.editIsDialog = false;
    },
    getMyCart() {
      this.$http({
        method: "post",
        url: "/api/resource/getMyResourceByStatus",
        params: {
          user_id: 123,
          status: 2
        }
      }).then(res => {
        this.myCartTable = res.data.data;
      });
    },
    getProvinces() {
      this.$http({
        method: "post",
        url: "/api/mateData/getProvinces",
        params: {}
      }).then(res => {
        this.provinceOptions = res.data.data;
      });
    },
    getCity() {
      this.$http({
        method: "post",
        url: "/api/mateData/getCity",
        params: {
          provinceId: this.myCartData.user_province
        }
      }).then(res => {
        this.cityOptions = res.data.data;
      });
    },
    getCounty() {
      this.$http({
        method: "post",
        url: "/api/mateData/getCounty",
        params: {
          cityId: this.myCartData.user_city
        }
      }).then(res => {
        this.countyOptions = res.data.data;
      });
    },
    checkOutCart(
      resource_id,
      user_name,
      user_phone,
      province,
      city,
      county,
      adress
    ) {
      this.$http({
        method: "post",
        url: "/api/orders/checkOutCart",
        params: {
          resource_id: resource_id,
          user_name: user_name,
          user_phone: user_phone,
          province: province,
          city: city,
          county: county,
          adress: adress
        }
      }).then(res => {
        alert(res.data);
      });
    }
  },
  // 通过computed计算属性及时改变
  computed: {
    // 总价
    totalPrice() {
      var price_total = 0;
      for (var i = 0; i < this.multipleSelection.length; i++) {
        price_total +=
          this.multipleSelection[i].resource_price *
          this.multipleSelection[i].counts;
      }
      return price_total;
    },
    // 总数
    totalNumber() {
      var number_total = 0;
      for (var i = 0; i < this.multipleSelection.length; i++) {
        number_total += this.multipleSelection[i].counts;
      }
      return number_total;
    },
    allOrders() {
      var oders = "";
      for (var i = 0; i < this.multipleSelection.length; i++) {
        for (var j = 0; j < this.multipleSelection[i].counts; j++) {
          oders += this.multipleSelection[i].resource_id + ",";
        }
      }
      return oders;
    }
  },
  components: {},
  created: function() {
    this.getMyCart();
    this.getProvinces();
    this.allOrders();
  }
};
</script>

<style scoped>
.cart {
  margin: 50px auto;
  width: 1000px;
}
.group_btn {
  margin-bottom: 30px;
  margin-left: 50%;
}
.addDialog .el-input {
  width: 90%;
}
.total_warpper {
  text-align: right;
  margin-top: 30px;
}
h3 {
  margin-top: 10px;
}
</style>