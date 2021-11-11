export const ALERTS_CONSTANT = {
    TYPE: {
        ERROR: {
            CLASS: 'alert-danger',
            AREA_CLASS: 'js-errorArea',
        },
        WARNING: {
            CLASS: 'alert-warning',
            AREA_CLASS: 'js-alertArea',
        },
        SUCCESS: {
            CLASS: 'alert-success',
            AREA_CLASS: 'js-successArea',
        },
    }
}

export const cleanAllAlerts = (seletor) => {
    cleanAlert(seletor, ALERTS_CONSTANT.TYPE.WARNING)
    cleanAlert(seletor, ALERTS_CONSTANT.TYPE.ERROR)
    cleanAlert(seletor, ALERTS_CONSTANT.TYPE.SUCCESS)
}

export const cleanAlert = (seletor, alertType) => {
    $(seletor + ' .'+ alertType.AREA_CLASS +'.alert').remove();
}

/**
	 * function responsible to build message
	 * by parameters
	 * @param {String} message message to show
	 * @param {String} selector selector css, for example id and class
	 * @param {ALERTS_CONSTANT.TYPE} alertType type of alert: success, warning
	 */
 export const showMessage = (message, selector, alertType) => {
    cleanAllAlerts(selector);
    const messageSpan = createDefaultMessage(message);
    const block = createMessageBlock(alertType)
                    .append(messageSpan)
    $(selector).html(block);
};

const createMessageBlock = (alertType) => {
    let block = $('<div class="alert alert-dismissible fade show" style="display:block;"></div>')
    let closeButton = $('<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>');
    let closeIcon = $('<span>X</span>')
    block
        .addClass(alertType.CLASS)
        .addClass(alertType.AREA_CLASS)
        .append(closeButton
                    .append(closeIcon)
                )
    return block;
}

const createDefaultMessage = (messages) => {
    if(Array.isArray(messages)){
        return $(`<ul>
            ${messages.length > 0 && messages
                .map(messageItem => `<li>${messageItem}</li>`).join('')}
        </ul>`)
    }
    return $('<span class="js-msg-area"><b>' + messages + '</b></span>');
}