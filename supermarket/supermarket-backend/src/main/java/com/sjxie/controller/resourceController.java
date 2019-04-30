package com.sjxie.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.sjxie.constants.constants;
import com.sjxie.dto.BaseController;
import com.sjxie.dto.Result;
import com.sjxie.entity.resource;
import com.sjxie.entity.user;
import com.sjxie.service.resourceService;
import com.sjxie.util.redisTemplateUtils;
import com.sjxie.vo.resourceCarVo;

@Controller
@CrossOrigin
@RequestMapping("/resource")
public class resourceController extends BaseController {
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private resourceService resourceservice;

	@Autowired
	private redisTemplateUtils redistemplates;

	/**
	 * 多条件查询商品列表
	 * 
	 * @param resource_type
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getResourceList")
	@ResponseBody
	public Result<List<resource>> getResourceList(
			@RequestParam(value = "resource_type", required = true) String resource_type,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Result<List<resource>> result = new Result<List<resource>>(0, "查询失败");
		if (!(StringUtils.isNotBlank(resource_type) && pageNum != null && pageSize != null)) {
			return result;
		}
		Result<List<resource>> resourceList = resourceservice.getResourceList(resource_type, pageNum, pageSize);
		logger.info("backend查询结果为：" + resourceList.toString());
		Result<Integer> resCount = resourceservice.countResourceByType(resource_type);
		resourceList.setPage(pageNum, pageSize, 0, resCount.getData());
		if (!resourceList.isSuccess()) {
			return result;
		}
		return resourceList;
	}

	/**
	 * 编辑商品
	 * 
	 * @param request
	 * @param name
	 * @param price
	 * @param type
	 * @param desc
	 * @param fileName
	 * @param specification
	 * @param inventory
	 * @return
	 */
	@RequestMapping("/updateResource")
	@ResponseBody
	public Result<Integer> updateResource(HttpServletRequest request,String resourceId, String name, String price, String type, String desc,
			String fileName, String specification, Integer inventory) {
		Result<Integer> result = new Result<Integer>(0, "添加失败");
		if (!(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(price) && StringUtils.isNotBlank(type)
				&& StringUtils.isNotBlank(desc) && StringUtils.isNotBlank(fileName)
				&& StringUtils.isNotBlank(specification))) {
			return result;
		}
		if(StringUtils.isNotBlank(resourceId)) {
			Result<Integer> deleteResourceById = resourceservice.deleteResourceById(resourceId);
			if(!(deleteResourceById.isSuccess() && deleteResourceById.getData() != null)) {
				return new Result<Integer>(0,"失败");
			}
		}
		String randomId = Math.random() + "";
		Date date = new Date();
		String res_id = randomId.substring(2, 9) + date.getTime();
		String img = redistemplates.getValueByKey(fileName);
		System.out.println(img);
		Result<Integer> addResource = resourceservice.addResource(res_id, name, desc, type, price, img, specification,
				inventory);
		result.setCode("1");
		result.setMessage("成功");
		result.setData(addResource.getData());
		return result;
	}
	
	/**
	 * 添加商品
	 * 
	 * @param request
	 * @param name
	 * @param price
	 * @param type
	 * @param desc
	 * @param fileName
	 * @param specification
	 * @param inventory
	 * @return
	 */
	@RequestMapping("/addResource")
	@ResponseBody
	public Result<Integer> addResource(HttpServletRequest request, String name, String price, String type, String desc,
			String fileName, String specification, Integer inventory) {
		Result<Integer> result = new Result<Integer>(0, "添加失败");
		if (!(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(price) && StringUtils.isNotBlank(type)
				&& StringUtils.isNotBlank(desc) && StringUtils.isNotBlank(fileName)
				&& StringUtils.isNotBlank(specification))) {
			return result;
		}
		String randomId = Math.random() + "";
		Date date = new Date();
		String res_id = randomId.substring(2, 9) + date.getTime();
		String img = redistemplates.getValueByKey(fileName);
		System.out.println(img);
		Result<Integer> addResource = resourceservice.addResource(res_id, name, desc, type, price, img, specification,
				inventory);
		result.setCode("1");
		result.setMessage("成功");
		result.setData(addResource.getData());
		return result;
	}

	/**
	 * 删除指定ID的资源
	 * @param request
	 * @param resId
	 * @return
	 */
	@RequestMapping("/deleteResource")
	@ResponseBody
	public Result<Integer> deleteResource(HttpServletRequest request, String resId) {
		Result<Integer> deleteResourceById = resourceservice.deleteResourceById(resId);
		return deleteResourceById;
	}

	/**
	 * 获取我的指定状态的资源
	 * @param request
	 * @param user_id
	 * @param status
	 * @return
	 */
	@RequestMapping("/getMyResourceByStatus")
	@ResponseBody
	public Result<List<resourceCarVo>> getMyResourceByStatus(HttpServletRequest request, String user_id, int status) {
		Result<List<resourceCarVo>> myResourceByStatus = resourceservice.getMyResourceByStatus(user_id, status);
		return myResourceByStatus;
	}

	@RequestMapping("/uploadImage")
	@ResponseBody
	public Result<Boolean> uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException {
		Result<Boolean> result = new Result<Boolean>(1, "上传成功");
		// 获取文件在服务器的储存位置
		// String path =
		// request.getSession().getServletContext().getRealPath("/upload");
		String path = "D:\\myProject\\supermarket-web\\static\\images";
		File filePath = new File(path);
		System.out.println("文件的保存路径：" + path);
		if (!filePath.exists() && !filePath.isDirectory()) {
			System.out.println("目录不存在，创建目录:" + filePath);
			filePath.mkdir();
		}

		// 获取原始文件名称(包含格式)
		String originalFileName = file.getOriginalFilename();
		System.out.println("原始文件名称：" + originalFileName);

		// 获取文件类型，以最后一个`.`为标识
		String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		System.out.println("文件类型：" + type);
		// 获取文件名称（不包含格式）
		String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

		// 设置文件新名称: 当前时间+文件名称（不包含格式）
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(d);
		String fileName = date + name + "." + type;
		System.out.println("新文件名称：" + fileName);
		// 在指定路径下创建一个文件
		File targetFile = new File(path, fileName);
		// 将文件保存到服务器指定位置
		try {
			file.transferTo(targetFile);
			System.out.println("上传成功");
			// 将文件在服务器的存储路径返回
			boolean setStringValue = redistemplates.setStringValue(originalFileName, "/" + fileName,
					constants.REDISDEFAULTTIME);
			result.setCode("1");
			return result;
		} catch (IOException e) {
			System.out.println("上传失败");
			e.printStackTrace();
			result.setCode("0");
			return result;
		} finally {
			// 关闭文件流
		}
	}

	/**
	 * 查看资源详情
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("/getResourceByResourceId")
	@ResponseBody
	public Result<resource> getResourceByResourceId(String resource_id) {
		Result<resource> result = new Result<>(1, "成功");
		Result<resource> resourceByResourceId = resourceservice.getResourceByResourceId(resource_id);
		if (resourceByResourceId != null && resourceByResourceId.isSuccess()) {
			result.setData(resourceByResourceId.getData());
			return result;
		} else {
			return new Result<>(0, "失败");
		}
	}
	
	/**
	 * 添加购物车
	 * @param resource_id
	 * @return
	 */
	@RequestMapping("/addCart")
	@ResponseBody
	public Result<Integer> addCart(HttpServletRequest request,String resourceId) {
		Result<Integer> result = new Result<>(1, "操作成功");
		user userInfo = this.getLOginUser(request);
		Result<Integer> addCart = resourceservice.addCart(resourceId,userInfo.getUser_id());
		if (addCart != null && addCart.isSuccess()) {
			result.setData(addCart.getData());
			return result;
		} else {
			return new Result<>(0, "操作失败");
		}
	}

	/**
	 * 模糊查询商品
	 * @param searchContext
	 * @return
	 */
	@RequestMapping("/resourceByResourceLikeName")
	@ResponseBody
	public Result<List<resource>> resourceByResourceLikeName(String searchContext){
		Result<List<resource>> resourceByResourceLikeName = resourceservice.resourceByResourceLikeName(searchContext);
		Result<List<resource>> result = new Result<List<resource>>();
		if(resourceByResourceLikeName.isSuccess() && resourceByResourceLikeName.getData() != null) {
			result.setCode("1");
			result.setMessage("成功");
			result.setData(resourceByResourceLikeName.getData());
		}else {
			result.setCode("0");
			result.setMessage("失败");
		}
		return result;
	}
	
	/**
	 * 多条件查询商品列表
	 * 
	 * @param resource_type
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getAllResourceList")
	@ResponseBody
	public Result<List<resource>> getAllResourceList(
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Result<List<resource>> result = new Result<List<resource>>(0, "查询失败");
		if (pageNum == null || pageSize == null) {
			return result;
		}
		Result<List<resource>> resourceList = resourceservice.getAllResourceList(pageNum, pageSize);
		logger.info("backend查询结果为：" + resourceList.toString());
		Result<Integer> resCount = resourceservice.countResource();
		resourceList.setPage(pageNum, pageSize, 0, resCount.getData());
		if (!resourceList.isSuccess()) {
			return result;
		}
		return resourceList;
	}
	
}
