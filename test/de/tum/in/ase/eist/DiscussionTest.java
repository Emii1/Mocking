package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    // TODO implement the tests

    @TestSubject
    private Discussion discussion = new Discussion();

    @Mock
    private Course courseMock;
    private Comment commentMock;

    @Test
    void testComment(){

        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        int newSize = discussion.getNumberOfComments() + 1;
        discussion.addComment(commentMock);
        assertEquals(newSize, discussion.getNumberOfComments());
        verify(commentMock);


    }
}
