import { BaseEntity } from './../../shared';

export class SupplierContractMc implements BaseEntity {
    constructor(
        public id?: number,
        public dateSigned?: any,
        public purchaseOrderId?: number,
        public supplyPartContractId?: number,
    ) {
    }
}