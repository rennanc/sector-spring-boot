const MARGIN_BY_LEVEL = 10

export const createSelectHierarchy = (selector, parentId, items, marginLeft = 0) => {
    items.filter(x => x.parentId === parentId).forEach(item => {
        const htmlSector = `<option style="margin-left:${marginLeft}" value="${item.id}">${item.name}</option>`
        document.querySelector(selector)
                        .insertAdjacentHTML('beforeend', htmlSector)
        createSelectHierarchy(selector, item.id, items, marginLeft + MARGIN_BY_LEVEL)
    });
}

export default createSelectHierarchy