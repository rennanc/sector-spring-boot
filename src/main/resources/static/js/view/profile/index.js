import createSelectHierarchy from "../../modules/selectHierarchy/index.js";
import { getFetchData, postFetchData } from "../../utils/apiUtils.js";

$(() => {
    addListeners();
    loadForm();
})

const loadForm = () => {
    loadSectors()
}

const addListeners = () => {
    document.querySelector('#submitForm').addEventListener('click',(e) => submitForm(e))
}

const loadSectors = () => {
    getFetchData(`/sector/`)
        .then((sectors) => {
            createSelectHierarchy('#sectors',0,sectors)
        })
}

const submitForm = (e) => {

    const sectorsSelected = document.querySelectorAll('#sectors option:checked')
    const sectorsIndexSelected = Array.from(sectorsSelected).map(el => el.value);

    const request = {
        name : document.querySelector('#name').value,
        sectorsIndexSelected : sectorsIndexSelected,
        isAgreeTerms: document.querySelector('#agreeTerm').checked
    }

    postFetchData('/profile', request)
        .then((response) => {
            console.log('ok')
        }).catch((err) => {
            console.log('fail')
        })
    
}