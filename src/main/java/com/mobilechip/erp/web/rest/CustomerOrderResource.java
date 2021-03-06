package com.mobilechip.erp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mobilechip.erp.service.CustomerOrderService;
import com.mobilechip.erp.web.rest.errors.BadRequestAlertException;
import com.mobilechip.erp.web.rest.util.HeaderUtil;
import com.mobilechip.erp.service.dto.CustomerOrderDTO;
import com.mobilechip.erp.service.dto.CustomerOrderCriteria;
import com.mobilechip.erp.service.CustomerOrderQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing CustomerOrder.
 */
@RestController
@RequestMapping("/api")
public class CustomerOrderResource {

    private final Logger log = LoggerFactory.getLogger(CustomerOrderResource.class);

    private static final String ENTITY_NAME = "customerOrder";

    private final CustomerOrderService customerOrderService;

    private final CustomerOrderQueryService customerOrderQueryService;

    public CustomerOrderResource(CustomerOrderService customerOrderService, CustomerOrderQueryService customerOrderQueryService) {
        this.customerOrderService = customerOrderService;
        this.customerOrderQueryService = customerOrderQueryService;
    }

    /**
     * POST  /customer-orders : Create a new customerOrder.
     *
     * @param customerOrderDTO the customerOrderDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new customerOrderDTO, or with status 400 (Bad Request) if the customerOrder has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/customer-orders")
    @Timed
    public ResponseEntity<CustomerOrderDTO> createCustomerOrder(@Valid @RequestBody CustomerOrderDTO customerOrderDTO) throws URISyntaxException {
        log.debug("REST request to save CustomerOrder : {}", customerOrderDTO);
        if (customerOrderDTO.getId() != null) {
            throw new BadRequestAlertException("A new customerOrder cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CustomerOrderDTO result = customerOrderService.save(customerOrderDTO);
        return ResponseEntity.created(new URI("/api/customer-orders/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /customer-orders : Updates an existing customerOrder.
     *
     * @param customerOrderDTO the customerOrderDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated customerOrderDTO,
     * or with status 400 (Bad Request) if the customerOrderDTO is not valid,
     * or with status 500 (Internal Server Error) if the customerOrderDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/customer-orders")
    @Timed
    public ResponseEntity<CustomerOrderDTO> updateCustomerOrder(@Valid @RequestBody CustomerOrderDTO customerOrderDTO) throws URISyntaxException {
        log.debug("REST request to update CustomerOrder : {}", customerOrderDTO);
        if (customerOrderDTO.getId() == null) {
            return createCustomerOrder(customerOrderDTO);
        }
        CustomerOrderDTO result = customerOrderService.save(customerOrderDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, customerOrderDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /customer-orders : get all the customerOrders.
     *
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of customerOrders in body
     */
    @GetMapping("/customer-orders")
    @Timed
    public ResponseEntity<List<CustomerOrderDTO>> getAllCustomerOrders(CustomerOrderCriteria criteria) {
        log.debug("REST request to get CustomerOrders by criteria: {}", criteria);
        List<CustomerOrderDTO> entityList = customerOrderQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * GET  /customer-orders/:id : get the "id" customerOrder.
     *
     * @param id the id of the customerOrderDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the customerOrderDTO, or with status 404 (Not Found)
     */
    @GetMapping("/customer-orders/{id}")
    @Timed
    public ResponseEntity<CustomerOrderDTO> getCustomerOrder(@PathVariable Long id) {
        log.debug("REST request to get CustomerOrder : {}", id);
        CustomerOrderDTO customerOrderDTO = customerOrderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(customerOrderDTO));
    }

    /**
     * DELETE  /customer-orders/:id : delete the "id" customerOrder.
     *
     * @param id the id of the customerOrderDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/customer-orders/{id}")
    @Timed
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable Long id) {
        log.debug("REST request to delete CustomerOrder : {}", id);
        customerOrderService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
