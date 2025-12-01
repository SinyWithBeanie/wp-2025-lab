# wp-2025-lab

Laboratory extercises for Web Programming 2025

Building a Book Reservation Service website.

<form method="GET" action="/books" style="margin-bottom: 20px">
    <label>Title:</label>
    <input type="text" name="title"
           th:value="${title}" />

    <label>Author:</label>
    <select name="authorId">
        <option th:value=""
                th:selected="${authorId == null}">
            -- All authors --
        </option>

        <option th:each="a : ${authors}"
                th:value="${a.id}"
                th:text="${a.name + ' ' + a.surname}"
                th:selected="${authorId != null and authorId == a.id}">
        </option>
    </select>

    <input type="submit" value="Filter"/>
</form>
