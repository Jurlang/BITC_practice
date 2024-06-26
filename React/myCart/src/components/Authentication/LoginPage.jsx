import "../../css/LoginPage.css";
import { useForm } from "react-hook-form";

const LoginPage = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const submitData = (formData) => console.log(formData);
  return (
    <section className="align_center form_page">
      <form onSubmit={handleSubmit(submitData)} className="authentication_form">
        <h2>로그인 폼</h2>
        <div className="form_inputs">
          <div>
            <label htmlFor="email">Email</label>
            <input {...register("email", { required: "이메일을 입력해주세요." })} type="email" id="email" className="form_text_input" placeholder="이메일 입력..." />
            {errors.email && <em className="form_error">{errors.email.message}</em>}
          </div>
          <div>
            <label htmlFor="password">Password</label>
            <input {...register("password", { required: "패스워드를 입력해주세요", minLength: { value: 4, message: "패스워드는 최소 4자 이상" } })} type="password" id="password" className="form_text_input" placeholder="패스워드" />
            {errors.password && <em className="form_error">{errors.password.message}</em>}
          </div>
          <button type="submit" className="search_button form_submit">
            Submit
          </button>
        </div>
      </form>
    </section>
  );
};

export default LoginPage;
