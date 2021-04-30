import React, {Component} from "react";
import logo from "../imageUtils/sin-perfil.jpg";
import chevronBas from "../imageUtils/icons8_expand_arrow.svg";
import EditComment from "./EditComment";


class CommetaireEspace extends Component{

    user=this.props.user
    idImage=this.props.imageId


    constructor(props) {
        super(props);
        this.state={
            active:!this.props.activation,
            comment:'',
            commentE:'',
            allComment:[],
            editComment:false,
            eId:''
        }
    }
    submitCommnent=(val)=>{
        this.setState({
            editComment: false,
            commentE: val
        })
        {
            fetch("http://localhost:8080/comment/update",
                {
                    method: "PUT",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({id:this.state.eId,  idImage : this.idImage, idUser : this.user.id, name : this.user.name, postComment : val })
                })
                .then(response => {
                    console.log(response)
                    this.takeData()
                }).catch((res)=>{
                console.log(res)})

        }

    }

    addCommentaire=()=>{
        {
            fetch("http://localhost:8080/comment/add",
                {
                    method: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({idImage : this.idImage, idUser : this.user.id, name : this.user.name, postComment : this.state.comment })
                })
                .then(response => {
                    console.log(response)
                    this.takeData()
                }).catch((res)=>{
                console.log(res)})

        }
    }
    takeData=()=>{
        fetch("http://localhost:8080/comment/all",{
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        })
            .then((res)=>{
                return res.json()}).then(data=>{
            this.setState({
                allComment:data
            })
        })
            .catch(function(res){ console.log(res) })
    }

    commentValue=(event)=>{
        this.setState({
            comment:event.target.value
        })
        console.log(this.state.comment)
    };
    removeComment=(id)=>{
        fetch(`http://localhost:8080/comment/delete/${id}`,{
            method: "DELETE",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        }).then(res=>{
            console.log(res)
            this.takeData()
        })
    };
    editComment=(id)=>{
        this.setState({
            editComment: true,
            eId:id
        })
    };

    componentWillMount() {
        this.takeData()
    }


    render() {

        console.log('imagedata '+JSON.stringify(this.state.allComment))
        console.log('userdata '+JSON.stringify(this.user))
        const modal= this.state.editComment ? <EditComment onsubmitComs={this.submitCommnent}/> : null;
    return (
        <div className="container col-11">
            <table className="table">
                <thead>
                <tr className="text-center py-0" id="commetaireBoutton">
                    <th className="text-center py-0"><span className="border-bottom">Comments</span>
                        <div className="text-center py-0">
                            <img className="position-relative py-0" src={chevronBas} alt="fleche bas" width="30px" height="30px" id="chevronBas"/>
                        </div>

                    </th>
                </tr>
                </thead>
                <tbody className="container" style={{display: this.state.active ? "block":"none"}}>

                {/*boucle*/}
                {this.state.allComment.length !== 0 && this.state.allComment.map((e) => {
                    if(e.idImage===this.idImage){
                        return(
                            <tr key={e.id}>
                                <td>
                                    <div className="d-flex align-items-center"><img className="rounded-circle border" src={logo} width="50" height="50" alt={"utilisateur"}/>{e.name}
                                        {e.idUser===this.user.id && (<div ><button className="btn btn-sm btn-danger ml-5" onClick={()=>this.removeComment(e.id)}>R</button>
                                            <button className="btn btn-sm btn-warning ml-1" onClick={()=>this.editComment(e.id)}>E</button></div>)}  </div>
                                    <p className="text-break border rounded border-0 offset-1">{e.postComment}</p>
                                </td>
                                {modal}
                            </tr>
                        )
                    }
                })
                }

                <tr>
                    <td>
                        <div>

                            <div ><textarea className="rounded" placeholder={"Your comment..."} onChange={this.commentValue}/>
                            <button className="btn btn-primary ml-3 mb-5" onClick={this.addCommentaire}>Comment</button></div>
                        </div>
                    </td>

                </tr>

                </tbody>
            </table>

        </div>
    )
}


}

export default CommetaireEspace
