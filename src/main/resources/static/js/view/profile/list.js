import { getFetchData } from "../../utils/apiUtils.js";

$(() => {
    loadData();
})

const loadData = () => {
    getFetchData('getProfiles')
        .then((profiles) => {
            profiles.forEach(profile => {
                let tableRow = `
                <td>${profile.id}</td>
                <td>${profile.name}</td>
                <td>${profile.sectorsIndexSelected.length}</td>
                `

                document.querySelector(`#profileList`)
                            .insertAdjacentHTML('beforeend', tableRow)
            });
        })
}