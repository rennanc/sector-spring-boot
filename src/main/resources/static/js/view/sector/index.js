import { getFetchData } from "../../utils/apiUtils.js";

const MARGIN_BY_LEVEL = 10

$(() => {
        loadForm();
})

const loadForm = () => {
    loadSectors()
}

const loadSectors = () => {
    getFetchData(`/sector/`)
        .then((sectors) => {
            setSectorHierarchyOptions(0, sectors)
        })
}

const setSectorHierarchyOptions = (parentId, sectors, marginLeft = 0) => {
    sectors.filter(x => x.parentId === parentId).forEach(sector => {
        const htmlSector = `<option style="margin-left:${marginLeft}" value="${sector.id}">${sector.name}</option>`
        document.querySelector(`#sectors`)
                        .insertAdjacentHTML('beforeend', htmlSector)
        setSectorHierarchyOptions(sector.id, sectors, marginLeft + MARGIN_BY_LEVEL)
    });
}