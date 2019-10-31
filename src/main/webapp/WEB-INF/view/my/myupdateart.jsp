<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="/rely/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/rely/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="/rely/kindeditor/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="/rely/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="/rely/kindeditor/lang/zh-CN.js"></script>
	<script
		src="/rely/js/jquery-3.2.1.js"></script>

	<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/rely/kindeditor/plugins/code/prettify.css',
				uploadJson : '/rely/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/rely/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		function query(){
		alert(editor1.html())
			//alert( $("[name='content1']").attr("src"))
		} 
	</script>
</head>
<body>
		<h2 style="color:red" align="center">修改文章</h2>
	<form id="id">
		<label for="bt" style="font-weight: bolder;">文章标题：</label>
		<input id="bt" value="${content.title }" name="title" type="text" class="form-control" >
		<br>
		<input type="hidden" name="id" value="${content.id }">
		<input type="hidden" name="userId" value="${content.user.id }">
		<textarea rows="10" style="width: 825px" cols="30" name="content1">${content.content }</textarea>
		<br>
		<br>
		<input  type="file"  value="${content.picture }" name="file" class="form-control" >
		<br> 
		<br>
		栏目：<select id="lm" name="channelId" class="form-control-sm">
 			 <option value="">请选择</option>
 			
		</select>
		分类：<select id="fl" name="categoryId" class="form-control-sm">
 			 <option>请选择</option>
		</select>
		<br>
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<button type="button" id="submit" class="btn btn-success">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="fh" class="btn btn-info">取消修改</button>
		</form>
</body>
			<script type="text/javascript">
				$(function(){
					
					var id='${content.user.id }'
					var channelId='${content.channelId }';
					var categoryId='${content.categoryId }';
					$("#fh").click(function(){
						
						$(".col-md-9").load("/My/showmyarticle?id="+id);
						
					})
					
					$.ajax({
						 url:"/My/sel_lm",
						 type:"post",
						 dataType:"json",
						 success:function(flag){
							 
							 for (var i = 0; i < flag.length; i++) {
								 if(flag[i].id==channelId){
									 $("#lm").append("<option selected value='"+flag[i].id+"'>"+flag[i].name+"</option>")
								 }else{
									 $("#lm").append("<option value='"+flag[i].id+"'>"+flag[i].name+"</option>")
								 }
								
							}
									 $.ajax({
										 url:"/My/sel_fl",
										 type:"post",
										 data:{'id':$("[name=channelId] option:selected").val()},
										 dataType:"json",
										 success:function(flag){
											 
											 for (var i = 0; i < flag.length; i++) {
												 if(categoryId==flag[i].id){
													 $("#fl").append("<option selected value='"+flag[i].id+"'>"+flag[i].name+"</option>")
												 }else{
													 $("#fl").append("<option value='"+flag[i].id+"'>"+flag[i].name+"</option>")
												 }
												
											}
											 
										 }
									})
						
						 }
					
					})
					
					
					
					$("#lm").change(function(){
						$("#fl option:gt(0)").remove();
						$.ajax({
							 url:"/My/sel_fl",
							 type:"post",
							 data:{'id':$(this).val()},
							 dataType:"json",
							 success:function(flag){
								 
								 for (var i = 0; i < flag.length; i++) {
									$("#fl").append("<option value='"+flag[i].id+"'>"+flag[i].name+"</option>")
								}
								 
							 }
						})
						
					})
					
					$("#submit").click(function(){
						
					 var formData=new FormData($("#id")[0]);//获取form标签的内容可以有file文件类型
					 formData.set("content",editor1.html());
                        $.ajax({ 
                             url:"/My/updateartice",
                             type:"post",
                             data:formData,
                             dataType:"json",
                             contentType: false,
                             processData:false,
                             success:function(flag){
                                 if(flag){
                                      alert("提交成功")
                                      $(".col-md-9").load("/My/showmyarticle?id="+${sessionScope.user.id });
                                 }else{
                                      alert("提交失败")
                                 }                                     
                             }
                        })
                        
                   })
						
					
					
				})
			
			</script>
</html>
