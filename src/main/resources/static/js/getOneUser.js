async function getOneUser(id) {
    let url = "adminApi/user/" + id;
    let response = await fetch(url);
    return await response.json();
}