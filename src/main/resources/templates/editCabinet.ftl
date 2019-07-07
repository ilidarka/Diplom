<#import "parts/common.ftl" as c>

<@c.page>


    <form action="/editCabinet/${user.username}" method="post" >

    <span class="cab--name">Имя: </span><input  class="border__bottom" type="text" name="firstName" value="${user.firstName}"><br>

    <span class="cab--name">Фамилмя: </span><input class="border__bottom" type="text" name="secondName" value="${user.secondName}"><br>

    <span class="cab--name">Отчёство: </span><input class="border__bottom" type="text" name="lastName" value="${user.lastName}"><br>

    <span class="cab--name">Город: </span><input class="border__bottom" type="text" name="city" value="${user.city}"><br>

    <span class="cab--name">Пол: </span><input class="border__bottom" type="text" name="gender" value="${user.gender}"><br>

    <span class="cab--name">Email: </span><input class="border__bottom" type="text" name="email" value="${user.email}"><br>

    <span class="cab--name">LinkedIn: </span><input class="border__bottom" type="text" name="linkedIn" value="${user.linkedIn}"><br>

    <span class="cab--name">Язык программирования: </span><input class="border__bottom" type="text" name="technology" value="${user.technology}"><br>

    <span class="cab--name">Образование: </span><input class="border__bottom" type="text" name="education" value="${user.education}"><br>

    <span class="cab--name">Телефонный номер: </span><input class="border__bottom" type="text" name="phoneNumber" value="${user.phoneNumber}"><br>

    <span class="cab--name">Позиция(Junior, Middle ...): </span><input class="border__bottom" type="text" name="position" value="${user.position}"><br>

    <span class="cab--name">Иностранный язык: </span><input class="border__bottom" type="text" name="language" value="${user.language}"><br>

    <span class="cab--name">О себе: </span><input class="border__bottom" type="text" name="about" value="${user.about}"><br>

    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>


</@c.page>
