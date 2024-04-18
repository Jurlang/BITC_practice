<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Todo <c:if test="${dto.tno == null}">Insert</c:if>
                    <c:if test="${dto.tno != null}">Update</c:if></title>
    </head>
    <body>
        <h1>Todo <c:if test="${dto.tno == null}">Insert</c:if>
                 <c:if test="${dto.tno != null}">Update</c:if></h1>
        <form action="
                      <c:if test="${dto.tno == null}">insert</c:if>
                      <c:if test="${dto.tno != null}">update</c:if>"
              method="post">
            <div>
                <c:if test="${dto.tno != null}"><input type="text" name="tno" id="tno" value="${dto.tno}" style="display: none;"></c:if>
                제목 : <c:if test="${dto.tno != null}"><input type="text" name="title" id="title" value="${dto.title}"></c:if>
                      <c:if test="${dto.tno == null}"><input type="text" name="title" id="title" value=""></c:if>
            </div>
            <div>날짜 : <c:if test="${dto.tno != null}"><input type="date" name="dueDate" id="dueDate" value="${dto.dueDate}"></c:if>
                       <c:if test="${dto.tno == null}"><input type="date" name="dueDate" id="dueDate"></c:if>
            </div>
            <div>
                <c:if test="${dto.tno != null}">완료 :
                <label><input type="radio" name="finished" value="true" <c:if test="${dto.finished == true}">checked</c:if>/>완료</label>
                <label><input type="radio" name="finished" value="false" <c:if test="${dto.finished == false}">checked</c:if>/>미완료</label>
                </c:if>
            </div>

        <input type="button" value="목록" onclick="location.href='list'"/>
        <input type="submit"
               <c:if test="${dto.tno != null}">value="수정"</c:if>
               <c:if test="${dto.tno == null}">value="등록"</c:if>
        >
        </form>
    </body>
</html>
