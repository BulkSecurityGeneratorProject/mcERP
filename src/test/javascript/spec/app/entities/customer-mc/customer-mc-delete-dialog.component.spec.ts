/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { McErpTestModule } from '../../../test.module';
import { CustomerMcDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/customer-mc/customer-mc-delete-dialog.component';
import { CustomerMcService } from '../../../../../../main/webapp/app/entities/customer-mc/customer-mc.service';

describe('Component Tests', () => {

    describe('CustomerMc Management Delete Component', () => {
        let comp: CustomerMcDeleteDialogComponent;
        let fixture: ComponentFixture<CustomerMcDeleteDialogComponent>;
        let service: CustomerMcService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [McErpTestModule],
                declarations: [CustomerMcDeleteDialogComponent],
                providers: [
                    CustomerMcService
                ]
            })
            .overrideTemplate(CustomerMcDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CustomerMcDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CustomerMcService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
