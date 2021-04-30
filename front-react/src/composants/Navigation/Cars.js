import React, {Component, Fragment} from "react";
import PiedNav from "../PiedNav";
import {castArray} from "lodash";
class Cars extends Component{

    constructor(props) {
        super(props);
        this.state={
            head:"",
            value:"",
            allCars:[],
        }
    }
    headChange=(event)=> {
        this.setState({
            head: event.target.value
        })
    }
    urlImageChange=(event)=>{
        this.setState({
            value: event.target.value
        })

    }
    addButton=()=>{
        fetch("http://localhost:8080/cars/add",
            {
                method: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({textHead: this.state.head, idComment: 0,image:this.state.value})
            })
            .then((res)=>{
                console.log(res)
                this.props.history.push("/home")
            })
            .catch((res)=>{
                console.log(res)})
    };
    removeOne=(valeur)=>{
        fetch(`http://localhost:8080/cars/delete/${valeur}`,{
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
    takeData=()=>{
        fetch("http://localhost:8080/cars/all",{
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        })
            .then((res)=>{
                return res.json()}).then(data=>{
            this.setState({
                allCars:data

            })
        })
            .catch(function(res){ console.log(res) })
    }
    componentWillMount() {
        this.takeData()
    }

    render() {

        return(
            <Fragment>
                <div className="col-10 offset-1">
                    <h1 className="text-center">Cars list</h1>
                <div className="table-responsive">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Header</th>
                            <th>Image</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody>

                        {this.state.allCars.length !== 0 && this.state.allCars.map((e) => {

                                return (
                                    <tr key={e.id}>
                                        <td>{e.textHead}</td>
                                        <td>{e.image}</td>
                                        <td><button className="btn btn-sm btn-danger" onClick={()=>this.removeOne(e.id)}>remove</button></td>
                                    </tr>
                                )


                        })

                        }
                        </tbody>
                    </table>
                </div>
                    <span className="text-center d-sm-flex justify-content-sm-center h3 my-5">Add a new image</span>
                  <form className="d-flex justify-content-around">
                      <div className="form-group text-left"><label>Image header : </label>
                          <input className="mx-3" type="text" onChange={this.headChange}/>
                      </div>
                      <div className="form-group text-left"><label>Image URL : </label>
                          <input className="mx-3" type="text" onChange={this.urlImageChange}/>
                      </div>
                      <button className="btn btn-sm btn-primary mb-md-5" type="button" onClick={this.addButton}>Add</button>
                  </form>

                </div>
                <PiedNav/>
            </Fragment>

            )

    }
}
export default Cars;
