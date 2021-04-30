import React, {Component, Fragment} from "react";
import PiedNav from "../PiedNav";

class LogIn extends Component{
    constructor(props) {
        super(props);
        this.state={
            email:"",
            psw:""
        }
    }

    logIn=()=>{

        fetch(`http://localhost:8080/users/auth/${this.state.email}`,{
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        })
            .then(response => {
                return response.json()
            }).then(data=>{
            console.log(JSON.stringify(data))
            if(JSON.stringify(data).toString()===this.state.psw){
                fetch(`http://localhost:8080/users/User/${this.state.email}`,{
                    method: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                }).then(response=>{
                    return response.json()
                }).then(data=>{
                    const user=data
                    console.log('name '+user.name)
                    console.log('user '+user)
                    this.props.func1(user)
                    this.props.func()
                })

            }
        })
    }

    onChangeMail=(event)=>{
        this.setState({email:event.target.value})
    }
    onChangePsw=(event)=>{
        this.setState({psw:event.target.value})
    }
    render() {
        return(<Fragment>
                <div className="contact-clean">
                    <form>
                        <h2 className="text-center">LogIn !</h2>
                        <div className="form-group"><input className="form-control" type="email" name="email"
                                                           placeholder="Email" onChange={this.onChangeMail}/></div>
                        <div className="form-group"><input className="form-control" type="password" name="password"
                                                           placeholder="password" onChange={this.onChangePsw}/></div>
                        <div className="form-group col d-flex justify-content-center">
                            <button className="btn btn-primary text-center" type="button" onClick={this.logIn}>send</button>
                        </div>
                    </form>
                </div>
                <PiedNav/>
        </Fragment>

            )

    }
}
export default LogIn
