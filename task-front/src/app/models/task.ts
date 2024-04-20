export interface Task {

    id ?: number
    title : string
    description : string
    due : string
    status : Status

}

export interface Status {
    id ?:number
    status ?: string
}