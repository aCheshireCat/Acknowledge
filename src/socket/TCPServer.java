package socket;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

public class TCPServer {
	
	protected Selector selector;
	protected Charset charset = Charset.forName("UTF-8");
	protected CharsetEncoder charsetEncoder = charset.newEncoder();
	protected CharsetDecoder charsetDecoder = charset.newDecoder();
	int count = 1;
	
	/**
	 * @throws Exception
	 */
	public TCPServer() throws Exception{
		this(8888);
	}
	
	/**
	 * @param port
	 * @throws Exception
	 */
	public TCPServer(int port) throws Exception {
		selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(port)); // port
		ssc.configureBlocking(false);
		ssc.register(selector, SelectionKey.OP_ACCEPT);// register

		while (true) {
			// selector �̡߳�select() ��������ֱ���пͻ������ӣ���������Ϣ����
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove(); // ɾ������Ϣ
				// ���ڵ�ǰ�߳��ڴ���
				handleSelectionKey(selectionKey);
			}
		}

	}

	/**
	 * @param selectionKey
	 * @throws Exception
	 */
	public void handleSelectionKey(SelectionKey selectionKey) throws Exception {
		if (selectionKey.isAcceptable()) {
			ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
			SocketChannel socketChannel = ssc.accept();
			socketChannel.configureBlocking(false);
			Socket socket = socketChannel.socket();
			// ����ע��һ�� OP_READ ��SelectionKey, ���տͻ��˵���Ϣ
			SelectionKey key = socketChannel.register(selector,SelectionKey.OP_READ);
			
			SocketAddress clientInfo = socket.getRemoteSocketAddress();
			key.attach("�� " + (count++) + " ���ͻ��� [" + clientInfo + "]");
			// ��ӡ
			println(key.attachment() + " ���ӳɹ�");

		} else if (selectionKey.isReadable()) {

			// ����Ϣ����
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
			SocketChannel sc = (SocketChannel) selectionKey.channel();

			try {
				int len = sc.read(byteBuffer);
				// ���len>0����ʾ�����롣���len==0, ��ʾ�����������Ҫ�ر� socketChannel
				if (len > 0) {
					byteBuffer.flip();
					String msg = charsetDecoder.decode(byteBuffer).toString();
					println(selectionKey.attachment() + " ��" + msg);
					
					// ���ݿͻ��˵���Ϣ�����ҵ���Ӧ�����
					String newMsg = "****************";
					ByteBuffer bt = charsetEncoder.encode(CharBuffer.wrap(newMsg + "\n"));
					sc.write(bt);
				} else {
					// ����������ر� socketChannel
					println(selectionKey.attachment()+ " �ѹر�����");
					sc.close();
				}

			} catch (Exception e) {
				// ���read�׳��쳣����ʾ�����쳣�жϣ���Ҫ�ر� socketChannel
				e.printStackTrace();
				sc.close();
			}
		} else if (selectionKey.isWritable()) {
			println("TODO: isWritable()");
		} else if (selectionKey.isConnectable()) {
			println("TODO: isConnectable()");
		} else {
			println("TODO: else");
		}

	}

	/**
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new TCPServer();
	}

}