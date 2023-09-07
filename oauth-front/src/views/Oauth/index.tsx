import { useEffect } from "react";
import { useCookies } from "react-cookie";
import { useNavigate, useParams } from "react-router-dom"


export default function Oauth() {

  //          state          //
  const { token } = useParams();
  const [cookies, setCookie] = useCookies();

  const navigator = useNavigate();

  //          effect          //
  useEffect(() => {
    if (!token) return;
    setCookie('token', token, { path: '/' });
    navigator('/');
  },[token]);

  return (
    <div>Oauth : {token}</div>
  )
}
