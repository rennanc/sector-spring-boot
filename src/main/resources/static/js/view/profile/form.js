import createSelectHierarchy from "../../modules/selectHierarchy/index.js";
import { getFetchData, getUrlParam, postFetchData } from "../../utils/apiUtils.js";
import { ALERTS_CONSTANT, showMessage } from "../../utils/messageUtils.js";
import { addErrorAtFormField, removeErrorFormField } from "../../utils/validationUtils.js";

$(() => {
    addListeners();
    loadData();
    loadForm();
})

const loadForm = () => {
    loadSectors()

    
}

const loadData = () => {
    let id = getUrlParam('id')
    if(id){
        getFetchData(`getProfile/${id}`)
            .then((profile) => {
                document.querySelector('#name').value = profile.name
                document.querySelector('#sectors').options
                    .forEach(option => {
                        option.selected = option.value == profile.s
                    });
            })
    }
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

      if(!validateForm()){
          return false
      }

    postFetchData('/profile/', request)
        .then((response) => {
            showMessage('Profile created with success.', '#messageBlock', ALERTS_CONSTANT.TYPE.SUCCESS)
        }).catch((err) => {
            showMessage(err, '#messageBlock', ALERTS_CONSTANT.TYPE.ERROR)
        })
    
}

export const validateForm = () => {

    jQuery.validator.setDefaults({
        ignore: [],
        debug: false,
        success: "valid"
    });

    var form = $("#profileForm");

    form.validate().destroy();

    form.validate({
        rules: {
            "name": {
                required: true,
            },
            "sectors": {
                required: true,
            },
            "agreeTerm": {
                required: true,
            }
        },
        highlight: (element) => {
            addErrorAtFormField(element);
        },
        unhighlight: (element) => {
            removeErrorFormField(element);
        }
    });
    jQuery.validator.messages.required = "";

    return form.valid();
}