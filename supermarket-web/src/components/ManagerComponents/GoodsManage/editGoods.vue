<template>
  <div style="margin: 20px;">
    <el-form
      :label-position="labelPosition"
      :rules="rules"
      label-width="80px"
      :model="formGoods"
      ref="formGoods"
    >
      <el-form-item label="名称" prop="name">
        <el-input v-model="formGoods.name" placeholder="请输入名称"></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model.number="formGoods.price" placeholder="请输入价格" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="种类">
        <el-select v-model="formGoods.type" placeholder="请选择种类">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
        <el-select v-model="formGoods.specification" placeholder="请选择规格">
          <el-option
            v-for="item in specifications"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="描述" prop="desc">
        <el-input type="textarea" v-model="formGoods.desc" placeholder="请描述该商品"></el-input>
      </el-form-item>
      <el-upload
        class="upload-demo"
        action="/api/resource/uploadImage"
        :on-change="handleChange"
        :file-list="fileList"
        list-type="picture"
      >
        <el-button size="small" type="primary">
          选择照片
          <i class="el-icon-upload el-icon--right"></i>
        </el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
      <el-button
        style="display:block;margin:0 auto"
        type="success"
        @click="onSubmit('formGoods')"
        round
      >确认添加</el-button>
    </el-form>
  </div>
</template>
<script>
import qs from "qs";
export default {
  data() {
    return {
      fileList: [],
      labelPosition: "right",
      formGoods: {
        name: "",
        price: "",
        type: "",
        fileName: "",
        desc: "",
        specification: "",
        inventory: 1
      },
      specifications: [
        {
          value: "1KG/份",
          label: "1KG/份"
        },
        {
          value: "1个/份",
          label: "1个/份"
        },
        {
          value: "1袋/份",
          label: "1袋/份"
        }
      ],
      options: [
        {
          value: "10001",
          label: "休闲"
        },
        {
          value: "10002",
          label: "饮品"
        },
        {
          value: "10003",
          label: "奶制"
        },
        {
          value: "10004",
          label: "膨化"
        },
        {
          value: "10005",
          label: "饼干"
        },
        {
          value: "10006",
          label: "糖果"
        },
        {
          value: "10007",
          label: "面包"
        },
        {
          value: "10008",
          label: "促销"
        },
        {
          value: "10009",
          label: "秒杀"
        }
      ],
      value: "",
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 1, max: 10, message: "长度在 1 到 10 个字符", trigger: "blur" }
        ],
        price: [
          { required: true, message: "价格不能为空" },
          { type: "number", message: "价格必须为数字值" }
        ],
        type: [
          { required: true, message: "请选择商品种类", trigger: "blur" },
          { min: 1, max: 10, message: "长度在 1 到 9 个字符", trigger: "blur" }
        ],
        desc: [
          { required: true, message: "请输入描述", trigger: "blur" },
          {
            min: 1,
            max: 10,
            message: "长度在 1 到 200 个字符",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    handleChange(file, fileList) {
      this.formGoods.fileName = fileList[0].name;
    },
    onSubmit(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.submitFormData();
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    submitFormData() {
      this.$http
        .post("/api/resource/addResource", qs.stringify(this.formGoods))
        .then(res => {
          layer.msg("成功");
          window.location.reload();
        });
    }
  }
};
</script>