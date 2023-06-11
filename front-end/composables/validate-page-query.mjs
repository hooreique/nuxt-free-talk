export const validatePageQuery = ({query = {}}) => {
    const {page, size, sort} = query;

    const pageOk = !page || parseInt(page) >= 0;

    const sizeOk = !size || (() => {
        const i = parseInt(size);
        return 0 < i && i <= 100;
    })();

    const sortOk = !sort || /^[A-Za-z]+(,asc|,desc)?$/.test(sort);

    return pageOk && sizeOk && sortOk;
};
