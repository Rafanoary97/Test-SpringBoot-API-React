import React,{Component,Fragment} from "react";
import PiedNav from "../PiedNav";
import CommetaireEspace from "../CommentaireEspace";
class Home extends Component{
    constructor(props) {
        super(props);
        this.state={
            allCars:[],
        }
    }
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
                <div className="col-10 offset-1 container">
                    <ul className="list-group">
                        {this.state.allCars.length !== 0 && this.state.allCars.map((e) => {

                            return (
                                <li key={e.id} className="list-group-item pt-md-5 mb-5 border-top border-dark">

                                    <div className="col mx-0">
                                        <div className="d-flex align-items-center">
                                            <div className="card">
                                                <div className="card-header">
                                                    <h5 className="mb-0">{e.textHead}</h5>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="col text-center d-flex flex-column align-items-center"><img className="w-50"
                                                                                                                    src={e.image} alt={"logo"}/>
                                        </div>
                                    </div>
                                    <CommetaireEspace user={this.props.valName} activation={this.props.activationPros} imageId={e.id}/>
                                </li>
                            )


                        })
                        }

                    </ul>
                </div>
                <PiedNav/>
            </Fragment>

            )
    }
}
export default Home
