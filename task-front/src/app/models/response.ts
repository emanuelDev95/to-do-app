export interface MessageResponse<D> {
    message : string;
    statusCode: number;
    data : D
}
