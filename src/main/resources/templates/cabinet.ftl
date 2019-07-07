<#import "parts/common.ftl" as c>

<@c.page>


    Кабинет пользователя: ${user.username}<br>


    <span class="cab--name">Имя: </span>${user.firstName}<br>
    <span class="cab--name">Фамилмя: </span>${user.secondName}<br>
    <span class="cab--name">Отчёство: </span>${user.lastName}<br>
    <span class="cab--name">Город: </span>${user.city}<br>
    <span class="cab--name">Пол: </span>${user.gender}<br>
    <span class="cab--name">Email: </span>${user.email}<br>
    <span class="cab--name">LinkedIn: </span>${user.linkedIn}<br>
    <span class="cab--name">Язык программирования: </span>${user.technology}<br>
    <span class="cab--name">Образование: </span>${user.education}<br>
    <span class="cab--name">Телефонный номер: </span>${user.phoneNumber}<br>
    <span class="cab--name">Позиция: </span>${user.position}<br>
    <span class="cab--name">Иностранный язык: </span>${user.language}<br>
    <span class="cab--name">О себе: </span>${user.about}<br>
    <span class="cab--name">Дата последнего редактирования: </span>${user.changeDate}<br>


    <a href="editCabinet/${user.username}">Change profile</a>
</@c.page>
