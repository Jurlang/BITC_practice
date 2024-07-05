import apiClient from "../utils/api-client";

export async function login(user) {
  const { data } = await apiClient.post("/loginCheck", user);
  localStorage.setItem("token", data.token);

  window.location = "/";
}


export async function signup(user){
  // const body = new FormData();
  // body.append('name', user.name);
  // body.append('age', user.age);
  // body.append('userID', user.userID);
  // body.append('userPW', user.userPW);
  // for (const x of body) {
  //   console.log(x);
  //  };
  await apiClient.post('/signup', user);

  window.location = '/';
}