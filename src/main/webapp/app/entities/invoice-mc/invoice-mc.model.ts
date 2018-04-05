import { BaseEntity } from './../../shared';

export class InvoiceMc implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public dateIssued?: any,
        public amountTotal?: number,
        public paymentDue?: number,
        public customerOrderId?: number,
        public customers?: BaseEntity[],
    ) {
    }
}