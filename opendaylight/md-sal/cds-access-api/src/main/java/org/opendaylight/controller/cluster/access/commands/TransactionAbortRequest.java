/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.cluster.access.commands;

import akka.actor.ActorRef;
import com.google.common.annotations.Beta;
import org.opendaylight.controller.cluster.access.ABIVersion;
import org.opendaylight.controller.cluster.access.concepts.TransactionIdentifier;

/**
 * A transaction request to perform the abort step of the three-phase commit protocol.
 *
 * @author Robert Varga
 */
@Beta
public final class TransactionAbortRequest extends TransactionRequest<TransactionAbortRequest> {
    private static final long serialVersionUID = 1L;

    public TransactionAbortRequest(final TransactionIdentifier target, final ActorRef replyTo) {
        super(target, replyTo);
    }

    @Override
    protected TransactionAbortRequestProxyV1 externalizableProxy(final ABIVersion version) {
        return new TransactionAbortRequestProxyV1(this);
    }

    @Override
    protected TransactionAbortRequest cloneAsVersion(final ABIVersion version) {
        return this;
    }
}
